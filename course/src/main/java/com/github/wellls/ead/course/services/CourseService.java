package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.CourseRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface CourseService {
    void delete(CourseModel courseModel);
    CourseModel save(CourseRecordDto courseRecordDto);
    boolean existsByName(String name);
}
