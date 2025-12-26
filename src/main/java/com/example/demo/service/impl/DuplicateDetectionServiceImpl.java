package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import java.util.*;

public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {
    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepository, DuplicateRuleRepository ruleRepository, DuplicateDetectionLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<Object> detectDuplicates(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        List<DuplicateRule> rules = ruleRepository.findAll();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");
        List<Object> duplicates = new ArrayList<>();

        if (rules.isEmpty()) return duplicates;

        for (Ticket otherTicket : openTickets) {
            if (Objects.equals(otherTicket.getId(), ticketId)) continue;

            for (DuplicateRule rule : rules) {
                boolean isDuplicate = false;
                double score = 0.0;

                switch (rule.getMatchType()) {
                    case "EXACT_MATCH":
                        if (ticket.getSubject() != null && otherTicket.getSubject() != null &&
                            ticket.getSubject().equalsIgnoreCase(otherTicket.getSubject())) {
                            isDuplicate = true;
                            score = 1.0;
                        }
                        break;
                    case "KEYWORD":
                        score = calculateKeywordSimilarity(ticket, otherTicket);
                        isDuplicate = score >= rule.getThreshold();
                        break;
                    case "SIMILARITY":
                        String text1 = (ticket.getDescription() != null ? ticket.getDescription() : "");
                        String text2 = (otherTicket.getDescription() != null ? otherTicket.getDescription() : "");
                        score = TextSimilarityUtil.similarity(text1, text2);
                        isDuplicate = score >= rule.getThreshold();
                        break;
                }

                if (isDuplicate) {
                    duplicates.add(otherTicket);
                    logRepository.save(new DuplicateDetectionLog(ticket, otherTicket, score));
                    break;
                }
            }
        }
        return duplicates;
    }

    private double calculateKeywordSimilarity(Ticket t1, Ticket t2) {
        String text1 = ((t1.getSubject() != null ? t1.getSubject() : "") + " " + 
                       (t1.getDescription() != null ? t1.getDescription() : "")).toLowerCase();
        String text2 = ((t2.getSubject() != null ? t2.getSubject() : "") + " " + 
                       (t2.getDescription() != null ? t2.getDescription() : "")).toLowerCase();
        
        String[] words1 = text1.split("\\s+");
        String[] words2 = text2.split("\\s+");
        
        Set<String> set1 = new HashSet<>(Arrays.asList(words1));
        Set<String> set2 = new HashSet<>(Arrays.asList(words2));
        
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        
        return union.isEmpty() ? 0.0 : (double) intersection.size() / union.size();
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}