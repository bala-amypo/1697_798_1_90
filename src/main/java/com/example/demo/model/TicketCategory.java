// package com.example.demo.model;

// import java.time.LocalDateTime;

// public class TicketCategory {
//     private Long id;
//     private String categoryName;
//     private String description;
//     private LocalDateTime createdAt;

//     public TicketCategory() {
//         this.createdAt = LocalDateTime.now();
//     }

//     public TicketCategory(String categoryName, String description) {
//         this.categoryName = categoryName;
//         this.description = description;
//         this.createdAt = LocalDateTime.now();
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getCategoryName() { return categoryName; }
//     public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }





package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_categories")
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    public TicketCategory() {
    }

    public TicketCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
