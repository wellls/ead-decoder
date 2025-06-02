package com.github.wellls.ead.authuser.services;

import com.github.wellls.ead.authuser.dtos.UserRecordDto;
import com.github.wellls.ead.authuser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    Page<UserModel> findAll(Pageable pageable);
    UserModel findById(UUID userId);
    void delete(UserModel userModel);
    UserModel registerUser(UserRecordDto userRecordDto);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserModel updateUser(UserRecordDto userRecordDto, UserModel userModel);
    void updatePassword(UserRecordDto userRecordDto, UserModel userModel);
    UserModel updateImage(UserRecordDto userRecordDto, UserModel byId);
}
