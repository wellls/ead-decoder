package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.repositories.LessonRepository;
import com.github.wellls.ead.course.services.LessonService;

public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
}
