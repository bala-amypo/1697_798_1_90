package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCategory_Id(Long id);
    List<Ticket> findByUser_Id(Long id);
    List<Ticket> findByStatus(String status);

    List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String subject, String description);
}
