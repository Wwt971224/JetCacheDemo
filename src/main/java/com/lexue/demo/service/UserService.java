package com.lexue.demo.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.lexue.demo.entity.User;

import java.util.concurrent.TimeUnit;

public interface UserService {

    @Cached(name="userCache.",key ="#userId" ,expire = 5,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    User selectById(Long userId);

    @CacheUpdate(name="userCache.", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="userCache.", key="#userId")
    void deleteBuId(Long userId);
}
