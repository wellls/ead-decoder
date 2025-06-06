package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.CourseRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    List<CourseModel> findAll();
    CourseModel findById(UUID courseId);
    CourseModel save(CourseRecordDto courseRecordDto);
    boolean existsByName(String name);
    CourseModel update(CourseRecordDto courseRecordDto, CourseModel courseModel);
    void delete(CourseModel courseModel);
}
