package com.example.demo.repository;

import com.example.demo.model.DuplicateDetectionLog;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class DuplicateDetectionLogRepositoryImpl implements DuplicateDetectionLogRepository {
    private final Map<Long, DuplicateDetectionLog> logs = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public DuplicateDetectionLog save(DuplicateDetectionLog log) {
        if (log.getId() == null) {
            log.setId(nextId++);
        }
        logs.put(log.getId(), log);
        return log;
    }

    @Override
    public List<DuplicateDetectionLog> findByTicket_Id(Long ticketId) {
        return logs.values().stream()
                .filter(l -> l.getTicket() != null && Objects.equals(l.getTicket().getId(), ticketId))
                .collect(Collectors.toList());
    }
}