package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import java.util.List;



public class DuplicateDetectionController {
    private final DuplicateDetectionService detectionService;

    public DuplicateDetectionController(DuplicateDetectionService detectionService) {
        this.detectionService = detectionService;
    }

    public List<Object> detectDuplicates(Long ticketId) {
        return detectionService.detectDuplicates(ticketId);
    }

    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return detectionService.getLogsForTicket(ticketId);
    }
}