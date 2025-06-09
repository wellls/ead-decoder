package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.dtos.LessonRecordDto;
import com.github.wellls.ead.course.models.LessonModel;
import com.github.wellls.ead.course.models.ModuleModel;
import com.github.wellls.ead.course.repositories.LessonRepository;
import com.github.wellls.ead.course.services.LessonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public LessonModel save(LessonRecordDto lessonRecordDto, ModuleModel moduleModel) {
        var lessonModel = new LessonModel();
        BeanUtils.copyProperties(lessonRecordDto, lessonModel);
        lessonModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        lessonModel.setModule(moduleModel);

        return lessonRepository.save(lessonModel);
    }
}
