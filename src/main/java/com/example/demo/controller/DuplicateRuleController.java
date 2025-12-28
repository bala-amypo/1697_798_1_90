// package com.example.demo.controller;

// import com.example.demo.model.DuplicateRule;
// import com.example.demo.service.DuplicateRuleService;


// public class DuplicateRuleController {
//     private final DuplicateRuleService ruleService;

//     public DuplicateRuleController(DuplicateRuleService ruleService) {
//         this.ruleService = ruleService;
//     }

//     public DuplicateRule createRule(DuplicateRule rule) {
//         return ruleService.createRule(rule);
//     }

//     public DuplicateRule getRule(Long id) {
//         return ruleService.getRule(id);
//     }
// }



// // package com.example.demo.controller;

// // import com.example.demo.model.DuplicateRule;
// // import com.example.demo.service.DuplicateRuleService;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/api/duplicate-rules")
// // public class DuplicateRuleController {

// //     private final DuplicateRuleService ruleService;

// //     public DuplicateRuleController(DuplicateRuleService ruleService) {
// //         this.ruleService = ruleService;
// //     }

// //     @PostMapping
// //     public DuplicateRule createRule(@RequestBody DuplicateRule rule) {
// //         return ruleService.createRule(rule);
// //     }

// //     @GetMapping("/{id}")
// //     public DuplicateRule getRule(@PathVariable Long id) {
// //         return ruleService.getRule(id);
// //     }
// // }



package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class DuplicateRuleController {
    
    @Autowired
    private DuplicateRuleService ruleService;

    @PostMapping
    public ResponseEntity<DuplicateRule> createRule(@RequestBody DuplicateRule rule) {
        try {
            DuplicateRule createdRule = ruleService.createRule(rule);
            return ResponseEntity.ok(createdRule);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuplicateRule> getRule(@PathVariable Long id) {
        try {
            DuplicateRule rule = ruleService.getRule(id);
            return ResponseEntity.ok(rule);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}