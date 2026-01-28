package com.example.email.sender.controller;

import ch.qos.logback.core.util.StringUtil;
import com.example.email.sender.constant.Constants;
import com.example.email.sender.dto.Email;
import com.example.email.sender.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Email controller
 */
@RestController
@Slf4j
@RequestMapping(Constants.EMAIL_SEND_API_PATH)
public class EmailController {

    private final EmailService emailService;

    /**
     * Constructor
     *
     * @param emailService {@link EmailService}
     */
    @Autowired
    public EmailController(final EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Sends an email based on email data
     *
     * @param email {@link Email}
     * @return {@link ResponseEntity<Object>}
     */
    @GetMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sendEmail(@RequestBody final Email email) {
        try {
            log.info("sendEmail - start");

            this.validateEmailAttributes(email);
            emailService.sendEmail(email);

            log.info("sendEmail - done");
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (RuntimeException runtimeException) {
            log.error("sendEmail - error stack: {}", runtimeException.toString());
            log.error("sendEmail - input email attributes: {}", email);
            return new ResponseEntity<>(Constants.EMAIL_SEND_API_BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Validates email content mandatory values
     *
     * @param email {@link Email}
     */
    private void validateEmailAttributes(final Email email) {
        log.debug("validateEmailAttributes - content: {}", email);

        if (StringUtil.isNullOrEmpty(email.getTargetAddress())) {
            log.error("validateEmailAttributes - error: {}", Constants.EMAIL_SEND_API_VALIDATION_TARGET_ERROR);
            throw new RuntimeException(Constants.EMAIL_SEND_API_VALIDATION_TARGET_ERROR);
        }

        if (StringUtil.isNullOrEmpty(email.getEmailBody())) {
            log.error("validateEmailAttributes - error: {}", Constants.EMAIL_SEND_API_VALIDATION_CONTENT_ERROR);
            throw new RuntimeException(Constants.EMAIL_SEND_API_VALIDATION_CONTENT_ERROR);
        }
    }
}
