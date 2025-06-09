package com.github.wellls.ead.course.services;

import com.github.wellls.ead.course.dtos.LessonRecordDto;
import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;

public interface LessonService {
    LessonModel save(LessonRecordDto lessonRecordDto, ModuleModel moduleModel);
}
