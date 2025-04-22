package org.example.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void aop(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-aop.xml");
        Target bean = applicationContext.getBean(Target.class);
        bean.selectAll();
        bean.selectById(4);
        bean.add(4,6);

        applicationContext.close();
    }
}