package com.online.course_management.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse{
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
