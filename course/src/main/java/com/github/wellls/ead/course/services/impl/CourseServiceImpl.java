package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.dtos.CourseRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;
import com.github.wellls.ead.course.repositories.CourseRepository;
import com.github.wellls.ead.course.repositories.LessonRepository;
import com.github.wellls.ead.course.repositories.ModuleRepository;
import com.github.wellls.ead.course.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public CourseServiceImpl(CourseRepository courseRepository, ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public CourseModel save(CourseRecordDto courseRecordDto) {
        var courseModel = new CourseModel();
        BeanUtils.copyProperties(courseRecordDto, courseModel);
        courseModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        courseModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return courseRepository.save(courseModel);
    }

    @Override
    public boolean existsByName(String name) {
        return courseRepository.existsByName(name);
    }

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {
        UUID courseId = courseModel.getCourseId();
        List<UUID> moduleIds = moduleRepository.findAllModuleIdsByCourseId(courseId);
        if (!moduleIds.isEmpty()) {
            lessonRepository.deleteAllLessonsByModuleIds(moduleIds);
            moduleRepository.deleteAllModulesByCourseId(courseId);
        }
        courseRepository.delete(courseModel);
    }
}
