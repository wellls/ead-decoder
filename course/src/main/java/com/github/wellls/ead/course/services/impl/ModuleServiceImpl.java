package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;
import com.github.wellls.ead.course.repositories.LessonRepository;
import com.github.wellls.ead.course.repositories.ModuleRepository;
import com.github.wellls.ead.course.services.ModuleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
