package com.lexue.demo.cache;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.lexue.demo.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserCache {

    @CacheInvalidate(name = "retcache:userCache:userId:", key = "#user.leId")
    @CacheInvalidate(name = "retcache:userCache:userMobile:", key = "#user.userMobile")
    @CacheInvalidate(name = "retcache:userCache:leId:", key = "#user.leId")
    void deleteAllUserCache(UserEntity userEntity) {

    }
}
