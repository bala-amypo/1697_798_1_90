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

    // RUN DUPLICATE DETECTION
    @GetMapping("/run/{ticketId}")
    public List<DuplicateDetectionLog> runDetection(@PathVariable Long ticketId) {
        return service.detectDuplicates(ticketId);
    }

    // GET LOGS FOR A TICKET
    @GetMapping("/ticket/{ticketId}")
    public List<DuplicateDetectionLog> getLogsForTicket(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }

    // GET LOG BY ID
    @GetMapping("/{id}")
    public DuplicateDetectionLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }
}
