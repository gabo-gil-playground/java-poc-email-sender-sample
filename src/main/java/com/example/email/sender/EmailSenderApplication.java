package com.example.email.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application main class
 */
@SpringBootApplication
public class EmailSenderApplication {

    /**
     * Starts {@link EmailSenderApplication} as Spring boot application with web-server feature
     *
     * @param args {@link String[]}
     */
    public static void main(final String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }
}
