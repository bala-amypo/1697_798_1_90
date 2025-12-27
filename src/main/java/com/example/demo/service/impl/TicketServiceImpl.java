// // package com.example.demo.service.impl;

// // import com.example.demo.model.Ticket;
// // import com.example.demo.model.User;
// // import com.example.demo.model.TicketCategory;
// // import com.example.demo.repository.TicketRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.repository.TicketCategoryRepository;
// // import com.example.demo.service.TicketService;
// // import java.util.List;

// // public class TicketServiceImpl implements TicketService {
// //     private final TicketRepository ticketRepository;
// //     private final UserRepository userRepository;
// //     private final TicketCategoryRepository categoryRepository;

// //     public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository, TicketCategoryRepository categoryRepository) {
// //         this.ticketRepository = ticketRepository;
// //         this.userRepository = userRepository;
// //         this.categoryRepository = categoryRepository;
// //     }

// //     @Override
// //     public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
// //         if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
// //             throw new RuntimeException("Description must be at least 10 characters");
// //         }
// //         User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
// //         TicketCategory category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
// //         ticket.setUser(user);
// //         ticket.setCategory(category);
// //         return ticketRepository.save(ticket);
// //     }

// //     @Override
// //     public Ticket getTicket(Long id) {
// //         return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
// //     }

// //     @Override
// //     public List<Ticket> getAllTickets() {
// //         return ticketRepository.findAll();
// //     }

// //     @Override
// //     public List<Ticket> getTicketsByUser(Long userId) {
// //         return ticketRepository.findByUser_Id(userId);
// //     }
// // }




package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public Ticket getTicket(Long id) {
        return tickets.stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {
        return tickets;
    }
}






// package com.example.demo.service.impl;

// import com.example.demo.model.Ticket;
// import com.example.demo.repository.TicketCategoryRepository;
// import com.example.demo.repository.TicketRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.TicketService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TicketServiceImpl implements TicketService {

//     private final TicketRepository ticketRepository;
//     private final UserRepository userRepository;
//     private final TicketCategoryRepository categoryRepository;

//     public TicketServiceImpl(
//             TicketRepository ticketRepository,
//             UserRepository userRepository,
//             TicketCategoryRepository categoryRepository
//     ) {
//         this.ticketRepository = ticketRepository;
//         this.userRepository = userRepository;
//         this.categoryRepository = categoryRepository;
//     }

//     @Override
//     public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
//         ticket.setUser(userRepository.findById(userId).orElse(null));
//         ticket.setCategory(categoryRepository.findById(categoryId).orElse(null));
//         return ticketRepository.save(ticket);
//     }

//     @Override
//     public Ticket getTicket(Long id) {
//         return ticketRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<Ticket> getAllTickets() {
//         return ticketRepository.findAll();
//     }

//     @Override
//     public List<Ticket> getTicketsByUser(Long userId) {
//         return ticketRepository.findByUserId(userId);
//     }
// }
