package com.github.wellls.ead.course.controllers;

import com.github.wellls.ead.course.dtos.LessonRecordDto;
import com.github.wellls.ead.course.services.LessonService;
import com.github.wellls.ead.course.services.ModuleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LessonController {
    final ModuleService moduleService;
    final LessonService lessonService;

    public LessonController(ModuleService moduleService, LessonService lessonService) {
        this.moduleService = moduleService;
        this.lessonService = lessonService;
    }

    @PostMapping("/modules/{moduleId}/lessons")
    public ResponseEntity<Object> saveLesson(@PathVariable(value = "moduleId") UUID moduleId,
                                             @RequestBody @Valid LessonRecordDto lessonRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lessonService.save(lessonRecordDto, moduleService.findById(moduleId).get()));
    }
}
