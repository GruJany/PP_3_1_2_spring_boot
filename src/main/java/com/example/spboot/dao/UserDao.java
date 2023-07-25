package com.example.spboot.dao;

import com.example.spboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    void deleteUserById(Integer id);

    List<User> getAllUsers();

    User updateUser(User user);

    Optional<User> getUserById(Integer id);
}
