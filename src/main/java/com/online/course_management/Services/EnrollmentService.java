package com.online.course_management.Services;

import com.online.course_management.DTO.*;
import com.online.course_management.entity.*;
import com.online.course_management.Exception.AlreadyEnrolledException;
import com.online.course_management.Exception.ResourceNotFoundException;
import com.online.course_management.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public String enrollInCourse(EnrollmentRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Courses courses = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

//        if (enrollmentRepository.findByStudentIdAndId(student.getId(), courses.getId()).isPresent()) {
//            System.out.println(student.getId());
//            System.out.println(courses.getId());
//            throw new AlreadyEnrolledException("Already enrolled in this course");
//        }

        if (enrollmentRepository.findByStudentIdAndCoursesId(student.getId(), courses.getId()).isPresent()) {
            System.out.println(student.getId());
            System.out.println(courses.getId());
            throw new AlreadyEnrolledException("Already enrolled in this course");
        }


        Enrollments enrollments = Enrollments.builder()
                .student(student)
                .courses(courses)
                .enrolledAt(LocalDateTime.now())
                .build();

        enrollmentRepository.save(enrollments);
        return "Enrollment successful";
    }

    public List<EnrollmentResponse> getMyEnrollments() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Enrollments> enrollments = enrollmentRepository.findAllByStudent(student);

        return enrollments.stream()
                .map(e -> new EnrollmentResponse(
                        e.getCourses().getTitle(),
                        e.getCourses().getDescription(),
                        e.getCourses().getPrice(),
                        e.getEnrolledAt()
                ))
                .collect(Collectors.toList());
    }
}
