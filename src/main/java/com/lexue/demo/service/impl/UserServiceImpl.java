package com.lexue.demo.service.impl;

import com.lexue.demo.entity.User;
import com.lexue.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User(1L, "1"));
    }

    @Override
    public User selectById(Long userId) {
        return userList.stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(userId);
    }

    @Override
    public void updateUser(User user) {
        User userExist = userList.stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(user.getUserId());
        userList.remove(userExist);
        userList.add(user);
    }

    @Override
    public void deleteBuId(Long userId) {
        User userExist = userList.stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(userId);
        userList.remove(userExist);
    }
}
