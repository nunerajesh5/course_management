package com.online.course_management.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {

    @Autowired
    private String courseTitle;

    @Autowired
    private String courseDescription;

    @Autowired
    private Double price;

    @Autowired
    private LocalDateTime enrolledAt;

}
