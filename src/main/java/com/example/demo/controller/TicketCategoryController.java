package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;

public class TicketCategoryController {
    private final TicketCategoryService categoryService;

    public TicketCategoryController(TicketCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public TicketCategory createCategory(TicketCategory category) {
        return categoryService.createCategory(category);
    }

    public TicketCategory getCategory(Long id) {
        return categoryService.getCategory(id);
    }
}