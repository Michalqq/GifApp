package com.ak.demoGif.model;

public interface EmailSender {
    boolean sendEmail(String to, String subject, String content);
}
