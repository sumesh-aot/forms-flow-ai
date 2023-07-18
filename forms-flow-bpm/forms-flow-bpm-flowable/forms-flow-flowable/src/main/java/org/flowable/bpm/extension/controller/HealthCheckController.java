package org.flowable.bpm.extension.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        // Perform health checks on Flowable engine components
        // Return appropriate response based on health status
        // Example: return ResponseEntity.ok("Flowable Engine is healthy");
        return ResponseEntity.ok().build();
    }
}
