package com.lexue.demo.service;

import com.alicp.jetcache.anno.*;
import com.lexue.demo.entity.User;

import java.util.concurrent.TimeUnit;

public interface UserService {

    @CacheRefresh(refresh = 1, timeUnit = TimeUnit.SECONDS, refreshLockTimeout = 60)
    @Cached(name = "retcache:userCache.", key = "#userId", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    @CachePenetrationProtect // 当缓存访问未命中的情况下，对并发进行的加载行为进行保护。当前版本实现的是单JVM内的保护，即同一个JVM中同一个key只有一个线程去加载，其它线程等待结果。
    User selectById(Long userId);

    @CacheUpdate(name="retcache:userCache.", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="retcache:userCache.", key="#userId")
    void deleteBuId(Long userId);
}
