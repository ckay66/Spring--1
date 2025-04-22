package org.example.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
//切面类注解 用于额外标识切面类 注意必须在当前类已经交由spring容器管理之后才会生效
//等价于  <aop:aspect ref="myAspect">
public class MyAspect {
    //通知 5种不同的通知提供了对应的通知注解
    //@通知类型(value="切点表达式",属性=值) 如果仅配置value那么value可以省略

    //切点表达式的抽取
    //定义方法使用注解定义切点表达式 方法名就是切点表达式的id
    @Pointcut("execution(* org.example.annotation.Target.select*(..))")
    // <aop:pointcut id="select" expression="execution(void com.sqsf.aop.Target.select*(..))"/>
    public void select(){}
    @Pointcut("execution(* org.example.annotation.Target.add(..))")
    // <aop:pointcut id="add" expression="execution(* com.sqsf.aop.Target.add(..))"/>
    public void add(){}

    //对于当前切面类 可以直接使用方法名() select() add()
    //其他切面类想使用 需要通过类名.方法名() MyAspect.select() MyAspect.add()

    //前置通知注解
    @Before("select()")
    //等价于<aop:before method="before" pointcut="execution(* com.sqsf.annotation.Target.select*(..))">
    public void before(){
        System.out.println("前置通知");
    }

    //后置通知注解
    @After("MyAspect.select()")
    //等价与<aop:after method="after" pointcut="execution(* com.sqsf.annotation.Target.select*(..))">
    public void after(){
        System.out.println("后置通知");
    }

    //环绕通知注解
    @Around("add()")
    //等价于<aop:around method="around" pointcut="execution(* com.sqsf.aop.Target.add(..))">
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("环绕通知"+ Arrays.toString(args));
        Object proceed = joinPoint.proceed(args);
        System.out.println("环绕通知"+proceed);
        return proceed;
    }

    //异常通知注解
    @AfterThrowing(value = "MyAspect.add()",throwing = "e")
    //等价于<aop:after-throwing method="afterThrowing" pointcut="execution(* com.sqsf.aop.Target.add(..))" throwing = "e">
    public void afterThrowing(Exception e){
        System.out.println("异常通知"+e);
    }

    //返回通知注解
    @AfterReturning(value = "MyAspect.add()",returning = "result")
    //<aop:after-returning method="afterReturning" returning="result" pointcut="execution(* com.sqsf.aop.Target.add(..))"/>
    public void afterReturning(Object result){
        System.out.println("返回通知"+result);
    }
}