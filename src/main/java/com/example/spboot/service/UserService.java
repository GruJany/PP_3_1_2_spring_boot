package com.example.spboot.service;

import com.example.spboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    void deleteUserById(Integer id);
    List<User> getAllUsers();
    User updateUser(Integer id, User user);
    Optional<User> getUserById(Integer id);
}
