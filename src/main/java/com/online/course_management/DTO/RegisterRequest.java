package com.online.course_management.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @Autowired
    private String name;

    @Autowired
    private String email;

    @Autowired
    private String password;

    @Autowired
    private String role;

}
