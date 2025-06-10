package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.LessonRecordDto;
import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface LessonService {
    LessonModel save(LessonRecordDto lessonRecordDto, ModuleModel moduleModel);
    Optional<LessonModel> findLessonIntoModule(UUID moduleId, UUID lessonId);
    void delete(LessonModel lessonModel);
    LessonModel update(LessonRecordDto lessonRecordDto, LessonModel lessonModel);
    Page<LessonModel> findAllLessonsIntoModule(Specification<LessonModel> spec, Pageable pageable);
}
