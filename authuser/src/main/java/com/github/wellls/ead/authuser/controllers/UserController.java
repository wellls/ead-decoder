package com.github.wellls.ead.authuser.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.wellls.ead.authuser.dtos.UserRecordDto;
import com.github.wellls.ead.authuser.models.UserModel;
import com.github.wellls.ead.authuser.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value="userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    @DeleteMapping ("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value="userId") UUID userId) {
        userService.delete(userService.findById(userId));
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable(value="userId") UUID userId,
                                             @RequestBody @JsonView(UserRecordDto.UserView.UserPut.class)
                                             UserRecordDto userRecordDto) {
        var userModel = userService.updateUser(userRecordDto, userService.findById(userId));
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<Object> updatePassword(@PathVariable(value="userId") UUID userId,
                                             @RequestBody @JsonView(UserRecordDto.UserView.PasswordPut.class)
                                             UserRecordDto userRecordDto) {
        var userModel = userService.findById(userId);
        if(!userModel.getPassword().equals(userRecordDto.oldPassword())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ERROR: Mismatched old password.");
        }
        userService.updatePassword(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body("Password updated successfully.");
    }

    @PutMapping("/{userId}/image")
    public ResponseEntity<Object> updateImage(@PathVariable(value="userId") UUID userId,
                                             @RequestBody @JsonView(UserRecordDto.UserView.ImagePut.class)
                                             UserRecordDto userRecordDto) {
        var userModel = userService.updateImage(userRecordDto, userService.findById(userId));
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }


}
