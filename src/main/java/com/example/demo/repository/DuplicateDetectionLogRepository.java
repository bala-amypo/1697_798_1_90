// package com.example.demo.repository;

// import com.example.demo.model.DuplicateDetectionLog;
// import java.util.List;

// public interface DuplicateDetectionLogRepository {
//     DuplicateDetectionLog save(DuplicateDetectionLog log);
//     List<DuplicateDetectionLog> findByTicket_Id(Long ticketId);
// }



package com.example.demo.repository;

import com.example.demo.model.DuplicateDetectionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DuplicateDetectionLogRepository
        extends JpaRepository<DuplicateDetectionLog, Long> {

    List<DuplicateDetectionLog> findByTicketId(Long ticketId);
}
