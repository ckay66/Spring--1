package org.example.test;

import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void live() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        applicationContext.close();
    }

    @Test
    public void scope2() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService u1 = (UserService) applicationContext.getBean("u2");
        UserService u2 = (UserService) applicationContext.getBean("u2");
        System.out.println(u1 == u2);
        System.out.println(u1.hashCode() + "|" + u2.hashCode());
        applicationContext.close();
    }

    @Test
    public void scope1() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService u1 = (UserService) applicationContext.getBean("userService");
        UserService u2 = (UserService) applicationContext.getBean("userService");
        System.out.println(u1 == u2);
        System.out.println(u1.hashCode() + "|" + u2.hashCode());
        applicationContext.close();
    }


    @Test
    public void test() {
        //1.加载配置 创建容器对象 ApplicationContext代表容器对象接口
        //1)ClassPathXmlApplicationContext 加载类路径(resource)下xml配置文件 创建spring容器对象(常用)
        //2)FileSystemXmlApplicationContext 加载文件系统下xml配置文件 创建spring容器对象
        //3)AnnotationConfigApplicationContext 加载注解配置类 创建spring容器对象
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        //2.调用getBean方法获取指定对象
        //1)getBean(String id) 根据配置的id进行对象的获取 因为spring中可以存储各种类型的对象 所以该方法返回Object对象 使用前需要强转
        UserService u1 = (UserService) applicationContext.getBean("userService");
        //2)getBean(Class c) 通过类型进行匹配 注意:如果在配置中存在多个相同class会报错
        UserService u2 = applicationContext.getBean(UserService.class);

        //3.使用
        u1.save();
        u2.save();

        //4.每个spring容器创建方式创建的spring容器拥有额外的close方法用于关闭容器
        applicationContext.close();
    }
}
