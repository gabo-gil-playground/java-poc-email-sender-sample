package com.example.email.sender.constant;

/**
 * Application constants values (avoid hard-coded text, magic numbers and repeated values)
 */
public interface Constants {
    String APP_HEALTH_MESSAGE_KEY = "status";
    String APP_HEALTH_MESSAGE_VALUE = "server is running";

    String EMAIL_SEND_API_PATH = "/api/v1/email";
    String EMAIL_SEND_API_BAD_REQUEST_ERROR = "send email - bad request";
    String EMAIL_SEND_API_VALIDATION_TARGET_ERROR = "send email - target address is not valid or empty";
    String EMAIL_SEND_API_VALIDATION_CONTENT_ERROR = "send email - content is not valid or empty";
}
