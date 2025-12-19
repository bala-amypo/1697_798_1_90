package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.TextSimilarityUtil;

@Service
public class DuplicateDetectionServiceImpl
        implements DuplicateDetectionService {

    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepo,
            DuplicateRuleRepository ruleRepo,
            DuplicateDetectionLogRepository logRepo) {

        this.ticketRepo = ticketRepo;
        this.ruleRepo = ruleRepo;
        this.logRepo = logRepo;
    }

    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket t : ticketRepo.findAll()) {
            if (!t.getId().equals(ticketId)) {
                double score = TextSimilarityUtil.similarity(
                        ticket.getDescription(), t.getDescription());

                if (score > 0) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(ticket);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    logs.add(logRepo.save(log));
                }
            }
        }
        return logs;
    }
}
