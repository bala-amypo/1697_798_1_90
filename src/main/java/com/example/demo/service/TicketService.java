// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.Ticket;

// public interface TicketService {

//     Ticket createTicket(Long userId, Long categoryId, Ticket ticket);

//     Ticket getTicket(Long ticketId);

//     List<Ticket> getTicketsByUser(Long userId);

//     List<Ticket> getAllTickets();
// }


package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Ticket;

public interface TicketService {

    Ticket createTicket(Long userId, Long categoryId, Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

    Ticket updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);
}
