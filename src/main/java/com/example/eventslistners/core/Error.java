package com.example.eventslistners.core;

import java.time.LocalDateTime;
import java.util.List;

public class Error {

    private int code;
    private List<ErrorDetail> details;
    private LocalDateTime timestamp = LocalDateTime.now();

    private Error(int code, List<ErrorDetail> details) {
        this.code = code;
        this.details = details;
    }

    public static Error of(int code, List<ErrorDetail> details) {
        return new Error(code, details);
    }

    public int getCode() {
        return code;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
