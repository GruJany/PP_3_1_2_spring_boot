package com.example.spboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.spboot.entity.User;
import com.example.spboot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String User(@PathVariable("id") Integer id,
                       ModelMap model) {
        return userService.getUserById(id).map(user -> {
                    model.addAttribute("user", user);
                    return "user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/create")
    public String create(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping(value = "/create/add")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/" + user.getId();
    }

    @PostMapping(value = "/{id}/update")
    public String update(@PathVariable("id") Integer id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/" + user.getId();
    }

    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}