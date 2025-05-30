package com.github.wellls.ead.authuser.services;

import com.github.wellls.ead.authuser.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    UserModel findById(UUID userId);
    void delete(UserModel userModel);
}
