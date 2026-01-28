package com.example.email.sender.controller;

import com.example.email.sender.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Health controller
 */
@RestController
@Slf4j
public class HealthController {

    /**
     * Retrieves application health check status message
     *
     * @return {@link ResponseEntity<Object>}
     */
    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> healthCheck() {
        HashMap<String, String> healthMessage = new HashMap<>();
        healthMessage.put(Constants.APP_HEALTH_MESSAGE_KEY, Constants.APP_HEALTH_MESSAGE_VALUE);

        return new ResponseEntity<>(healthMessage, HttpStatus.OK);
    }
}
