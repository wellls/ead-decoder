package com.github.wellls.ead.authuser.services.impl;

import com.github.wellls.ead.authuser.exceptions.NotFoundException;
import com.github.wellls.ead.authuser.models.UserModel;
import com.github.wellls.ead.authuser.repositories.UserRepository;
import com.github.wellls.ead.authuser.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(UUID userId) {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);
        if(userModelOptional.isEmpty()) {
            throw new NotFoundException("Error: User not found.");
        }
        return userModelOptional.get();
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
