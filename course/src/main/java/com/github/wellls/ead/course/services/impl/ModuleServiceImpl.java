package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.dtos.ModuleRecordDto;
import com.github.wellls.ead.course.exceptions.NotFoundException;
import com.github.wellls.ead.course.models.CourseModel;
import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;
import com.github.wellls.ead.course.repositories.LessonRepository;
import com.github.wellls.ead.course.repositories.ModuleRepository;
import com.github.wellls.ead.course.services.ModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, LessonRepository lessonRepository) {
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        UUID moduleId = moduleModel.getModuleId();
        lessonRepository.deleteAllLessonsByModuleId(moduleId);
        moduleRepository.delete(moduleModel);
    }

    @Override
    public ModuleModel save(ModuleRecordDto moduleRecordDto, CourseModel courseModel) {
        var moduleModel = new ModuleModel();
        BeanUtils.copyProperties(moduleRecordDto, moduleModel);
        moduleModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        moduleModel.setCourse(courseModel);

        return moduleRepository.save(moduleModel);
    }

    @Override
    public Page<ModuleModel> findAllModulesIntoCourse(Specification<ModuleModel> spec, Pageable pageable) {
        return moduleRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId) {
        Optional<ModuleModel> moduleModelOptional = moduleRepository.findModuleIntoCourse(courseId, moduleId);
        if(moduleModelOptional.isEmpty()){
            throw new NotFoundException("Error: Module not found for this Course.");
        }
        return moduleModelOptional;
    }
}
