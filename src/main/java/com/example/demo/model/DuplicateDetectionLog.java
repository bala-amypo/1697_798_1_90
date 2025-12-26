// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "duplicate_detection_logs")
// public class DuplicateDetectionLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "ticket_id")
//     private Ticket ticket;

//     @ManyToOne
//     @JoinColumn(name = "matched_ticket_id")
//     private Ticket matchedTicket;

//     private Double matchScore;

//     private LocalDateTime detectedAt;

    

//     public Long getId() {
//         return id;
//     }

//     public Ticket getTicket() {
//         return ticket;
//     }

//     public void setTicket(Ticket ticket) {
//         this.ticket = ticket;
//     }

//     public Ticket getMatchedTicket() {
//         return matchedTicket;
//     }

//     public void setMatchedTicket(Ticket matchedTicket) {
//         this.matchedTicket = matchedTicket;
//     }

//     public Double getMatchScore() {
//         return matchScore;
//     }

//     public void setMatchScore(Double matchScore) {
//         this.matchScore = matchScore;
//     }

//     public LocalDateTime getDetectedAt() {
//         return detectedAt;
//     }

//     public void setDetectedAt(LocalDateTime detectedAt) {
//         this.detectedAt = detectedAt;
//     }
// }


@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket baseTicket;

    @ManyToOne
    private Ticket matchedTicket;

    private double similarityScore;

    public DuplicateDetectionLog() {}

    // REQUIRED
    public DuplicateDetectionLog(Ticket baseTicket, Ticket matchedTicket, double similarityScore) {
        this.baseTicket = baseTicket;
        this.matchedTicket = matchedTicket;
        this.similarityScore = similarityScore;
    }
}
