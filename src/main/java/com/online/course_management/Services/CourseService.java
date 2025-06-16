package com.online.course_management.Services;

import com.online.course_management.DTO.*;
import com.online.course_management.entity.Courses;
import com.online.course_management.Exception.ResourceNotFoundException;
import com.online.course_management.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponse createCourse(CourseRequest request) {
        Courses courses = Courses.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        courseRepository.save(courses);

        return mapToResponse(courses);
    }

    public CourseResponse updateCourse(Integer id, CourseRequest request) {
        Courses courses = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        courses.setTitle(request.getTitle());
        courses.setDescription(request.getDescription());
        courses.setPrice(request.getPrice());

        courseRepository.save(courses);

        return mapToResponse(courses);
    }

    public void deleteCourse(Integer id) {
        Courses course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        courseRepository.delete(course);
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CourseResponse mapToResponse(Courses courses) {
        return new CourseResponse(courses.getId(), courses.getTitle(), courses.getDescription(), courses.getPrice());
    }
}
