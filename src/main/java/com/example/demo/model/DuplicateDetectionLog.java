package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket matchedTicket;

    private Double matchScore;

    private LocalDateTime detectedAt;

    @PrePersist
    void created() {
        detectedAt = LocalDateTime.now();
    }
}
