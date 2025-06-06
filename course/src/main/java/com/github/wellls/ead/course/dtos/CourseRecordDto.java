package com.github.wellls.ead.course.dtos;

import com.github.wellls.ead.course.enums.CourseLevel;
import com.github.wellls.ead.course.enums.CourseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CourseRecordDto(@NotBlank
                              String name,

                              @NotBlank
                              String description,

                              @NotNull
                              CourseStatus courseStatus,

                              @NotNull
                              CourseLevel courseLevel,

                              @NotNull
                              UUID userInstructor,

                              String imageUrl) {
}
