package com.github.wellls.ead.course.repositories;

import com.github.wellls.ead.course.models.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonModel, UUID>, JpaSpecificationExecutor<LessonModel> {
    @Modifying
    @Query("DELETE FROM LessonModel l WHERE l.module.moduleId IN :moduleIds")
    void deleteAllLessonsByModuleIds(List<UUID> moduleIds);

    @Modifying
    @Query("DELETE FROM LessonModel l WHERE l.module.moduleId = :moduleId")
    void deleteAllLessonsByModuleId(UUID moduleId);

    @Query(value="select * from tb_lessons where module_module_id = :moduleId", nativeQuery = true)
    List<LessonModel> findAllLessonsIntoModule(@Param("moduleId") UUID moduleId);

    @Query(value="select * from tb_lessons where module_module_id = :moduleId and lesson_id = :lessonId", nativeQuery = true)
    Optional<LessonModel> findLessonIntoModule(@Param("moduleId") UUID moduleId, @Param("lessonId") UUID lessonId);
}
