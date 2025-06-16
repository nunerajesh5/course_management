package com.online.course_management.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {

    @Autowired
    private Integer courseId;


}
