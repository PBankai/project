package com.junitworkshop.project.service;

public class DateTimeException extends Exception{
public DateTimeException() {
        super();
    }

    // Constructor that accepts a message
    public DateTimeException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public DateTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
