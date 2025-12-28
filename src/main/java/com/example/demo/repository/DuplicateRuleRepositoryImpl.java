package com.example.demo.repository;

import com.example.demo.model.DuplicateRule;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DuplicateRuleRepositoryImpl implements DuplicateRuleRepository {
    private final Map<Long, DuplicateRule> rules = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public DuplicateRule save(DuplicateRule rule) {
        if (rule.getId() == null) {
            rule.setId(nextId++);
        }
        rules.put(rule.getId(), rule);
        return rule;
    }

    @Override
    public Optional<DuplicateRule> findById(Long id) {
        return Optional.ofNullable(rules.get(id));
    }

    @Override
    public Optional<DuplicateRule> findByRuleName(String ruleName) {
        return rules.values().stream()
                .filter(r -> r.getRuleName().equals(ruleName))
                .findFirst();
    }

    @Override
    public List<DuplicateRule> findAll() {
        return new ArrayList<>(rules.values());
    }
}