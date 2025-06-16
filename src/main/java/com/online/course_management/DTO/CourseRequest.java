package com.online.course_management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    @Autowired
    private String title;

    @Autowired
    private String description;

    @Autowired
    private Double price;


}
