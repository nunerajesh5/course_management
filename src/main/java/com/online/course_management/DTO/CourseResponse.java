package com.online.course_management.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    @Autowired
    private Integer id;

    @Autowired
    private String title;

    @Autowired
    private String description;

    @Autowired
    private Double price;



}
