package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;

@RestController
@RequestMapping("/api/rules")

public class DuplicateRuleController {
    private final DuplicateRuleService ruleService;

    public DuplicateRuleController(DuplicateRuleService ruleService) {
        this.ruleService = ruleService;
    }

    public DuplicateRule createRule(DuplicateRule rule) {
        return ruleService.createRule(rule);
    }

    public DuplicateRule getRule(Long id) {
        return ruleService.getRule(id);
    }
}