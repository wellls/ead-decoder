package com.github.wellls.ead.course.services.impl;

import com.github.wellls.ead.course.repositories.ModuleRepository;
import com.github.wellls.ead.course.services.ModuleService;

public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }
}
