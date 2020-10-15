package com.lexue.demo.controller;

import com.lexue.demo.entity.User;
import com.lexue.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.selectById(userId);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteBuId(userId);
    }


}
