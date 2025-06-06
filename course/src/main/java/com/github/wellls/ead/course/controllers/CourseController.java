package com.github.wellls.ead.course.controllers;

import com.github.wellls.ead.course.dtos.CourseRecordDto;
import com.github.wellls.ead.course.models.CourseModel;
import com.github.wellls.ead.course.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {
    final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCourse(@RequestBody @Valid CourseRecordDto courseRecordDto) {
        if(courseService.existsByName(courseRecordDto.name())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Course Name is Already Taken");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<CourseModel>> getAllCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Object> getOneCourse(@PathVariable(value = "courseId") UUID courseId) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "courseId") UUID courseId) {
        courseService.delete(courseService.findById(courseId));
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Object> updateCourse(@PathVariable(value = "courseId") UUID courseId,
                                               @RequestBody @Valid CourseRecordDto courseRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update(courseRecordDto, courseService.findById(courseId)));
    }
}
