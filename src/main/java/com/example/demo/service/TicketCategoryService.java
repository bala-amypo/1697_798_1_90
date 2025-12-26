// package com.example.demo.service;

// import com.example.demo.model.TicketCategory;

// public interface TicketCategoryService {
//     TicketCategory createCategory(TicketCategory category);
//     TicketCategory getCategory(Long id);
// }


package com.example.demo.service;

import com.example.demo.model.TicketCategory;
import java.util.List;

public interface TicketCategoryService {

    TicketCategory createCategory(TicketCategory category);

    List<TicketCategory> getAllCategories();   // ✅ ADD THIS

    TicketCategory getCategory(Long id);
}

