package com.online.course_management.Repository;

import com.online.course_management.entity.Enrollments;
import com.online.course_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollments, Integer> {
    Optional<Enrollments> findByStudentIdAndCoursesId(int studentId, int coursesId);
    List<Enrollments> findAllByStudent(User Student);
}
