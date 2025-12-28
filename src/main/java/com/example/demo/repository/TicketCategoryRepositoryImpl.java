package com.example.demo.repository;

import com.example.demo.model.TicketCategory;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TicketCategoryRepositoryImpl implements TicketCategoryRepository {
    private final Map<Long, TicketCategory> categories = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return categories.values().stream().anyMatch(c -> c.getCategoryName().equals(categoryName));
    }

    @Override
    public TicketCategory save(TicketCategory category) {
        if (category.getId() == null) {
            category.setId(nextId++);
        }
        categories.put(category.getId(), category);
        return category;
    }

    @Override
    public Optional<TicketCategory> findById(Long id) {
        return Optional.ofNullable(categories.get(id));
    }

    @Override
    public List<TicketCategory> findAll() {
        return new ArrayList<>(categories.values());
    }
}