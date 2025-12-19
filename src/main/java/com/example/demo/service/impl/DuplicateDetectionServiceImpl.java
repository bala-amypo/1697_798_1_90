package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository) {

        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket baseTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found"));

        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");
        List<DuplicateDetectionLog> results = new ArrayList<>();

        for (Ticket t : openTickets) {
            if (!t.getId().equals(ticketId)) {

                double score = TextSimilarityUtil.similarity(
                        baseTicket.getDescription(),
                        t.getDescription());

                if (score > 0) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(baseTicket);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    results.add(logRepository.save(log));
                }
            }
        }
        return results;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("log not found"));
    }
}
