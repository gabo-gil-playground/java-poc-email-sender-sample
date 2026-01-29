package com.example.email.sender.service;

import com.example.email.sender.dto.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * Email service
 */
@Service
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    /**
     * Constructor
     *
     * @param mailSender {@link JavaMailSender}
     */
    @Autowired
    public EmailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Sends an email based on email data
     *
     * @param email {@link Email}
     */
    public void sendEmail(final Email email) {
        log.info("sendEmail - start");
        log.debug("sendEmail - email attributes: {}", email);

        try {
            // start elapsed time tracking
            StopWatch sendEmailElapsedTime = new StopWatch();
            sendEmailElapsedTime.start();

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setTo(email.getTargetAddress());
            mimeMessageHelper.setSubject(email.getEmailSubject());
            mimeMessageHelper.setText(email.getEmailBody(), true);

            mailSender.send(mimeMessage);

            // stop elapsed time tracking
            sendEmailElapsedTime.stop();

            log.info("sendEmail - elapsed time: {} ms", sendEmailElapsedTime.getTotalTimeMillis());
            log.info("sendEmail - done");
        } catch (MessagingException messagingException) {
            log.error("sendEmail - send error: {}", messagingException.toString());
            throw new RuntimeException(messagingException);
        }
    }
}
