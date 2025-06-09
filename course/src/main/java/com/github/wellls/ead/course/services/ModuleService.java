package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.ModuleRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import com.github.wellls.ead.course.models.ModuleModel;

public interface ModuleService {
    void delete(ModuleModel moduleModel);
    ModuleModel save(ModuleRecordDto moduleRecordDto, CourseModel courseModel);
}
