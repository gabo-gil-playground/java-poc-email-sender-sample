package com.example.email.sender.service;

import com.example.email.sender.dto.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * Email service
 */
@Service
@Slf4j
public class EmailService {

    /**
     * Sends an email based on email data
     *
     * @param email {@link Email}
     */
    public void sendEmail(final Email email) {
        log.info("sendEmail - start");
        log.debug("sendEmail - report content: {}", email);

        // start create pdf report elapsed time tracking
        StopWatch sendEmailElapsedTime = new StopWatch();
        sendEmailElapsedTime.start();

        // TO BE IMPLEMENTED

        // stop create pdf report elapsed time tracking
        sendEmailElapsedTime.stop();

        log.info("sendEmail - elapsed time: {} ms", sendEmailElapsedTime.getTotalTimeMillis());
        log.info("sendEmail - done");
    }
}
