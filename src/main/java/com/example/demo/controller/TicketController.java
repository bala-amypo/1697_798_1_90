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

    // CREATE
    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        return service.createTicket(ticket);
    }

    // READ ALL
    @GetMapping
    public List<Ticket> getAll() {
        return service.getAllTickets();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Ticket update(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {
        return service.updateTicket(id, ticket);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTicket(id);
    }
}
