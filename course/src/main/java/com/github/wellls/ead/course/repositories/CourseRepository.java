package com.github.wellls.ead.course.repositories;

import com.github.wellls.ead.course.models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {
    boolean existsByName(String name);
}
