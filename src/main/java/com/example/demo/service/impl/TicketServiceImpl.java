package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TicketCategoryRepository categoryRepository;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
            UserRepository userRepository,
            TicketCategoryRepository categoryRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getTicketsByUser(long userId) {
        return ticketRepository.findByUserId(userId);
    }
}
