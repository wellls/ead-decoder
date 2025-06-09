package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.ModuleRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import com.github.wellls.ead.course.models.ModuleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ModuleService {
    ModuleModel save(ModuleRecordDto moduleRecordDto, CourseModel courseModel);
    Page<ModuleModel> findAllModulesIntoCourse(Specification<ModuleModel> spec, Pageable pageable);
    Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);
    ModuleModel update(ModuleRecordDto moduleRecordDto, ModuleModel moduleModel);
    void delete(ModuleModel moduleModel);
}
