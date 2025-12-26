// // package com.example.demo.service.impl;

// // import java.util.List;

// // import org.springframework.stereotype.Service;

// // import com.example.demo.model.Ticket;
// // import com.example.demo.model.User;
// // import com.example.demo.model.TicketCategory;
// // import com.example.demo.repository.TicketRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.repository.TicketCategoryRepository;
// // import com.example.demo.service.TicketService;

// // @Service
// // public class TicketServiceImpl implements TicketService {

// //     private final TicketRepository ticketRepository;
// //     private final UserRepository userRepository;
// //     private final TicketCategoryRepository categoryRepository;

// //     public TicketServiceImpl(
// //             TicketRepository ticketRepository,
// //             UserRepository userRepository,
// //             TicketCategoryRepository categoryRepository) {

// //         this.ticketRepository = ticketRepository;
// //         this.userRepository = userRepository;
// //         this.categoryRepository = categoryRepository;
// //     }

// //     @Override
// //     public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {

// //         if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
// //             throw new RuntimeException("description too short");
// //         }

// //         User user = userRepository.findById(userId)
// //                 .orElseThrow(() -> new RuntimeException("user not found"));

// //         TicketCategory category = categoryRepository.findById(categoryId)
// //                 .orElseThrow(() -> new RuntimeException("category not found"));

// //         ticket.setUser(user);
// //         ticket.setCategory(category);
// //         ticket.setStatus("OPEN");

// //         return ticketRepository.save(ticket);
// //     }

// //     @Override
// //     public Ticket getTicket(Long ticketId) {
// //         return ticketRepository.findById(ticketId)
// //                 .orElseThrow(() -> new RuntimeException("ticket not found"));
// //     }

// //     @Override
// //     public List<Ticket> getTicketsByUser(Long userId) {
// //         return ticketRepository.findByUser_Id(userId);
// //     }

// //     @Override
// //     public List<Ticket> getAllTickets() {
// //         return ticketRepository.findAll();
// //     }
// // }

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TicketCategoryRepository categoryRepo;

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        User user = userRepo.findById(userId).orElseThrow();
        TicketCategory category = categoryRepo.findById(categoryId).orElseThrow();

        ticket.setUser(user);
        ticket.setCategory(category);

        return ticketRepo.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElseThrow();
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket existing = ticketRepo.findById(id).orElseThrow();

        existing.setSubject(ticket.getSubject());
        existing.setDescription(ticket.getDescription());
        existing.setStatus(ticket.getStatus());

        return ticketRepo.save(existing);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }
}

