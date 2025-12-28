// package com.example.demo.controller;

// import com.example.demo.model.TicketCategory;
// import com.example.demo.service.TicketCategoryService;

// public class TicketCategoryController {
//     private final TicketCategoryService categoryService;

//     public TicketCategoryController(TicketCategoryService categoryService) {
//         this.categoryService = categoryService;
//     }

//     public TicketCategory createCategory(TicketCategory category) {
//         return categoryService.createCategory(category);
//     }

//     public TicketCategory getCategory(Long id) {
//         return categoryService.getCategory(id);
//     }
// }



// // package com.example.demo.controller;

// // import com.example.demo.model.TicketCategory;
// // import com.example.demo.service.TicketCategoryService;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/categories")
// // public class TicketCategoryController {

// //     private final TicketCategoryService categoryService;

// //     public TicketCategoryController(TicketCategoryService categoryService) {
// //         this.categoryService = categoryService;
// //     }

// //     @PostMapping
// //     public TicketCategory createCategory(@RequestBody TicketCategory category) {
// //         return categoryService.createCategory(category);
// //     }

// //     @GetMapping("/{id}")
// //     public TicketCategory getCategory(@PathVariable Long id) {
// //         return categoryService.getCategory(id);
// //     }
// // }








package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class TicketCategoryController {
    
    @Autowired
    private TicketCategoryService categoryService;

    @PostMapping
    public ResponseEntity<TicketCategory> createCategory(@RequestBody TicketCategory category) {
        try {
            TicketCategory createdCategory = categoryService.createCategory(category);
            return ResponseEntity.ok(createdCategory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketCategory> getCategory(@PathVariable Long id) {
        try {
            TicketCategory category = categoryService.getCategory(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}