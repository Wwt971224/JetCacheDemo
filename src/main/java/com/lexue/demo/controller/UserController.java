package com.lexue.demo.controller;

import com.lexue.demo.domain.UserDTO;
import com.lexue.demo.domain.UserVO;
import com.lexue.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/user/userId/{userId}")
    public UserVO getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/user/leId/{leId}")
    public UserVO getUserByLeId(@PathVariable("leId") String leId) {
        return userService.getUserByLeId(leId);
    }

    @GetMapping("/user/mobile/{userMobile}")
    public UserVO getByMobile(@PathVariable("userMobile") String userMobile) {
        return userService.getUserByMobile(userMobile);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);

    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        UserDTO userDTO = UserDTO.builder().userId(userId).build();
        userService.deleteUser(userDTO);
    }

}
