package com.lexue.demo.aop;

import com.lexue.demo.annotation.ClearAllUserCache;
import com.lexue.demo.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

@Aspect
@Component
public class ClearAllUserCacheAspect {

    @Before("@annotation(com.lexue.demo.annotation.ClearAllUserCache)&&args(user)")
    public void before(JoinPoint jp, User user) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        if (Objects.isNull(signature)) {
            return;
        }
        Method method = signature.getMethod();
        if (Objects.isNull(method)) {
            return;
        }
        if (!method.isAnnotationPresent(ClearAllUserCache.class)) {
            return;
        }
        ClearAllUserCache clearAllUserCache = method.getAnnotation(ClearAllUserCache.class);
        if (Objects.isNull(clearAllUserCache)) {
            return;
        }
        System.out.println(user);

    }

}
