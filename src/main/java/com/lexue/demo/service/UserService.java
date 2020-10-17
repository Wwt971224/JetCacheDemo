package com.lexue.demo.service;

import com.alicp.jetcache.anno.*;
import com.lexue.demo.annotation.ClearAllUserCache;
import com.lexue.demo.entity.User;

import java.util.concurrent.TimeUnit;

public interface UserService {

//    @CacheRefresh(refresh = 1, timeUnit = TimeUnit.SECONDS, refreshLockTimeout = 60)
    @Cached(name = "retcache:userCache:userId:", key = "#userId", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    @CachePenetrationProtect // 当缓存访问未命中的情况下，对并发进行的加载行为进行保护。当前版本实现的是单JVM内的保护，即同一个JVM中同一个key只有一个线程去加载，其它线程等待结果。
    User selectById(Long userId);


//    @CacheRefresh(refresh = 1, timeUnit = TimeUnit.SECONDS, refreshLockTimeout = 60)
    @Cached(name = "retcache:userCache:userMobile:", key = "#userMobile", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    @CachePenetrationProtect // 当缓存访问未命中的情况下，对并发进行的加载行为进行保护。当前版本实现的是单JVM内的保护，即同一个JVM中同一个key只有一个线程去加载，其它线程等待结果。
    User selectByMobile(String userMobile);


    void updateUser(User user);

    void deleteBuId(Long userId);


}
