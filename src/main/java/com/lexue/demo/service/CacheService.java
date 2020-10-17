package com.lexue.demo.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.lexue.demo.entity.User;

public interface CacheService {
    @CacheInvalidate(name="retcache:userCache:userMobile:", key="#user.userMobile")
    void deleteCacheMobile(User user);

    @CacheInvalidate(name="retcache:userCache:userId:", key="#user.userId")
    @CacheInvalidate(name="retcache:userCache:userId:", key="#user.userId")
    void deleteCacheUserId(User user);
}
