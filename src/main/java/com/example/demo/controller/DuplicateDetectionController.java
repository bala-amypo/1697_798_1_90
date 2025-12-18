 package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService service;

    public DuplicateDetectionController(DuplicateDetectionService service) {
        this.service = service;
    }

    @GetMapping("/run/{ticketId}")
    public List<DuplicateDetectionLog> run(@PathVariable Long ticketId) {
        return service.detectDuplicates(ticketId);
    }
}
