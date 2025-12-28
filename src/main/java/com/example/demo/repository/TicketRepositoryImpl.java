package com.example.demo.repository;

import com.example.demo.model.Ticket;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TicketRepositoryImpl implements TicketRepository {
    private final Map<Long, Ticket> tickets = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(nextId++);
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(tickets.get(id));
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(tickets.values());
    }

    @Override
    public List<Ticket> findByStatus(String status) {
        return tickets.values().stream()
                .filter(t -> status.equals(t.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findByCategory_Id(Long categoryId) {
        return tickets.values().stream()
                .filter(t -> t.getCategory() != null && Objects.equals(t.getCategory().getId(), categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findByUser_Id(Long userId) {
        return tickets.values().stream()
                .filter(t -> t.getUser() != null && Objects.equals(t.getUser().getId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String subject, String description) {
        return tickets.values().stream()
                .filter(t -> (t.getSubject() != null && t.getSubject().toLowerCase().contains(subject.toLowerCase())) ||
                           (t.getDescription() != null && t.getDescription().toLowerCase().contains(description.toLowerCase())))
                .collect(Collectors.toList());
    }
}