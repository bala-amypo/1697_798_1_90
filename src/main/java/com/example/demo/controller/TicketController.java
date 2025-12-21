package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    // CREATE (matches service signature)
    @PostMapping("/{userId}/{categoryId}")
    public Ticket create(
            @PathVariable Long userId,
            @PathVariable Long categoryId,
            @RequestBody Ticket ticket) {

        return service.createTicket(userId, categoryId, ticket);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        return service.getTicket(id);
    }

    // READ BY USER
    @GetMapping("/user/{userId}")
    public List<Ticket> getByUser(@PathVariable Long userId) {
        return service.getTicketsByUser(userId);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Ticket> getAll() {
        return service.getAllTickets();
    }
}
