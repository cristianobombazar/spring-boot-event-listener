package com.example.eventslistners.core;

public class ErrorDetail {
    private String messageUser;
    private String messageDeveloper;

    private ErrorDetail(String messageUser, String messageDeveloper) {
        this.messageUser = messageUser;
        this.messageDeveloper = messageDeveloper;
    }

    public static ErrorDetail of(String messageUser, String messageDeveloper) {
        return new ErrorDetail(messageUser, messageDeveloper);
    }

    public String getMessageUser() {
        return messageUser;
    }

    public String getMessageDeveloper() {
        return messageDeveloper;
    }
}
