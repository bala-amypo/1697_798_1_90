package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    // CREATE
    @PostMapping("/{userId}/{categoryId}")
    public Ticket createTicket(
            @PathVariable Long userId,
            @PathVariable Long categoryId,
            @RequestBody Ticket ticket) {
        return service.createTicket(userId, categoryId, ticket);
    }

    // READ ALL
    @GetMapping
    public List<Ticket> getAllTickets() {
        return service.getAllTickets();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {
        return service.updateTicket(id, ticket);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
    }
}
