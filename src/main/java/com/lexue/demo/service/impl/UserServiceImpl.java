package com.lexue.demo.service.impl;

import com.lexue.demo.annotation.ClearAllUserCache;
import com.lexue.demo.entity.User;
import com.lexue.demo.entity.UserList;
import com.lexue.demo.service.CacheService;
import com.lexue.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private CacheService cacheService;

    @Resource
    private UserList userList;

    @Override
    public User selectById(Long userId) {
        return userList.getUserList().stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(userId);
    }

    @Override
    public User selectByMobile(String userMobile) {
        return userList.getUserList().stream().collect(Collectors.toMap(User::getUserMobile, Function.identity())).get(userMobile);
    }

    @Override
    public void updateUser(User user) {
        User userExist = userList.getUserList().stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(user.getUserId());
        //清手机号缓存
        cacheService.deleteCacheMobile(userExist);
        cacheService.deleteCacheUserId(userExist);
        userList.getUserList().remove(userExist);
        userList.getUserList().add(user);
    }

    @Override
    public void deleteBuId(Long userId) {
        User userExist = userList.getUserList().stream().collect(Collectors.toMap(User::getUserId, Function.identity())).get(userId);
        userList.getUserList().remove(userExist);
        cacheService.deleteCacheMobile(userExist);
        cacheService.deleteCacheUserId(userExist);
    }

}
