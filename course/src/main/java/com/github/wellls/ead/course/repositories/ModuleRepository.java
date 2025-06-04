package com.github.wellls.ead.course.repositories;

import com.github.wellls.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {
    @Modifying
    @Query("DELETE FROM ModuleModel m WHERE m.course.courseId = :courseId")
    void deleteAllModulesByCourseId(UUID courseId);

    @Query("SELECT m.moduleId FROM ModuleModel m WHERE m.course.courseId = :courseId")
    List<UUID> findAllModuleIdsByCourseId(UUID courseId);
}
