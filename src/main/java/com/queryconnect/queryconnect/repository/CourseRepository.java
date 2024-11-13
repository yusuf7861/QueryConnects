package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}