package com.ak.demoGif.model;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
