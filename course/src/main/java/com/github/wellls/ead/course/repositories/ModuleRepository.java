package com.github.wellls.ead.course.repositories;

import com.github.wellls.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID>, JpaSpecificationExecutor<ModuleModel> {
    @Modifying
    @Query("DELETE FROM ModuleModel m WHERE m.course.courseId = :courseId")
    void deleteAllModulesByCourseId(@Param("courseId") UUID courseId);

    @Query("SELECT m.moduleId FROM ModuleModel m WHERE m.course.courseId = :courseId")
    List<UUID> findAllModuleIdsByCourseId(@Param("courseId") UUID courseId);

    @Query(value="select * from tb_modules where course_course_id = :courseId and module_id = :moduleId", nativeQuery = true)
    Optional<ModuleModel> findModuleIntoCourse(@Param("courseId") UUID courseId, @Param("moduleId") UUID moduleId);
}
