package com.lexue.demo.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.lexue.demo.entity.User;

import java.util.concurrent.TimeUnit;

public interface UserService {

    @Cached(name="retcache:userCache.",key ="#userId" ,expire = 3600,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.REMOTE)
    User selectById(Long userId);

    @CacheUpdate(name="retcache:userCache.", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="retcache:userCache.", key="#userId")
    void deleteBuId(Long userId);
}
