// package com.example.demo.repository;

// import com.example.demo.model.TicketCategory;
// import java.util.List;
// import java.util.Optional;

// public interface TicketCategoryRepository {
//     boolean existsByCategoryName(String categoryName);
//     TicketCategory save(TicketCategory category);
//     Optional<TicketCategory> findById(Long id);
//     List<TicketCategory> findAll();
// }

package com.example.demo.repository;

import com.example.demo.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository
        extends JpaRepository<TicketCategory, Long> {

    boolean existsByCategoryName(String categoryName);
}



