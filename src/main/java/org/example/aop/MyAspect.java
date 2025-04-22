package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class MyAspect {
    public void before(){
        System.out.println("前置通知");
    }
    public void after(){
        System.out.println("后置通知");
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("环绕通知"+ Arrays.toString(args));
        Object proceed = joinPoint.proceed(args);
        System.out.println("环绕通知"+proceed);
        return proceed;
    }
    public void afterThrowing(Exception e){
        System.out.println("异常通知"+e);
    }
    public void afterReturning(Object result){
        System.out.println("返回通知"+result);
    }
}