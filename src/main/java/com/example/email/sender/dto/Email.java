package com.example.email.sender.dto;

import lombok.*;

/**
 * Email POJO
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Email {
    @NonNull
    String targetAddress;

    String emailSubject;

    @NonNull
    String emailBody;
}
