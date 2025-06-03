package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.repositories.CourseRepository;
import com.github.wellls.ead.course.services.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
