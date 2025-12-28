// package com.example.demo.controller;

// import com.example.demo.model.DuplicateDetectionLog;
// import com.example.demo.service.DuplicateDetectionService;
// import java.util.List;



// public class DuplicateDetectionController {
//     private final DuplicateDetectionService detectionService;

//     public DuplicateDetectionController(DuplicateDetectionService detectionService) {
//         this.detectionService = detectionService;
//     }

//     public List<Object> detectDuplicates(Long ticketId) {
//         return detectionService.detectDuplicates(ticketId);
//     }

//     public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
//         return detectionService.getLogsForTicket(ticketId);
//     }
// }



// // package com.example.demo.controller;

// // import com.example.demo.model.DuplicateDetectionLog;
// // import com.example.demo.service.DuplicateDetectionService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/duplicate-detection")
// // public class DuplicateDetectionController {

// //     private final DuplicateDetectionService detectionService;

// //     public DuplicateDetectionController(DuplicateDetectionService detectionService) {
// //         this.detectionService = detectionService;
// //     }

// //     @PostMapping("/{ticketId}")
// //     public List<Object> detectDuplicates(@PathVariable Long ticketId) {
// //         return detectionService.detectDuplicates(ticketId);
// //     }

// //     @GetMapping("/{ticketId}")
// //     public List<DuplicateDetectionLog> getLogsForTicket(@PathVariable Long ticketId) {
// //         return detectionService.getLogsForTicket(ticketId);
// //     }
// // }






package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {
    
    @Autowired
    private DuplicateDetectionService detectionService;

    @PostMapping("/detect/{ticketId}")
    public ResponseEntity<List<Object>> detectDuplicates(@PathVariable Long ticketId) {
        try {
            List<Object> duplicates = detectionService.detectDuplicates(ticketId);
            return ResponseEntity.ok(duplicates);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/logs/{ticketId}")
    public ResponseEntity<List<DuplicateDetectionLog>> getLogsForTicket(@PathVariable Long ticketId) {
        List<DuplicateDetectionLog> logs = detectionService.getLogsForTicket(ticketId);
        return ResponseEntity.ok(logs);
    }
}