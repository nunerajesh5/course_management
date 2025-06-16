package com.online.course_management.Exception;

public class AlreadyEnrolledException extends RuntimeException{
    public AlreadyEnrolledException(String message) {
        super(message);
    }
}
