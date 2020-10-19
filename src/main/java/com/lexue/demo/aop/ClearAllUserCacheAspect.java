package com.lexue.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClearAllUserCacheAspect {

    //    @Before("@annotation(com.lexue.demo.annotation.ClearAllUserCache)&&args(user)")
//    public void before(JoinPoint jp, User user) {
//        MethodSignature signature = (MethodSignature) jp.getSignature();
//        if (Objects.isNull(signature)) {
//            return;
//        }
//        Method method = signature.getMethod();
//        if (Objects.isNull(method)) {
//            return;
//        }
//        if (!method.isAnnotationPresent(ClearAllUserCache.class)) {
//            return;
//        }
//        ClearAllUserCache clearAllUserCache = method.getAnnotation(ClearAllUserCache.class);
//        if (Objects.isNull(clearAllUserCache)) {
//            return;
//        }
//        System.out.println(user);
//    }
//    @Pointcut("execution(* com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.*(..))")
    @Pointcut("execution(* com.lexue.demo.service.impl.UserServiceImpl.*(..))")
    private void orderDbAspect() {
    }

    @Before("orderDbAspect()")
    public void switchToCms() {
        System.out.println("进行了");
    }

}
