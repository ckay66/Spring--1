package org.example.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-annotation.xml")
public class AnnotationTest {
    @Autowired
    Target target;
    @Test
    public void aop(){
        target.selectAll();
        target.selectById(3);
        target.add(4,9);
    }
}