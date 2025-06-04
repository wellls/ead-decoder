package com.github.wellls.ead.course.repositories;

import com.github.wellls.ead.course.models.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonModel, UUID> {
    @Modifying
    @Query("DELETE FROM LessonModel l WHERE l.module.moduleId IN :moduleIds")
    void deleteAllLessonsByModuleIds(List<UUID> moduleIds);

    @Modifying
    @Query("DELETE FROM LessonModel l WHERE l.module.moduleId = :moduleId")
    void deleteAllLessonsByModuleId(UUID moduleId);
}
