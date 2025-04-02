package org.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.example.d.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)//标识配置spring运行环境
@ContextConfiguration("classpath:spring.xml")//标识配置读取spring配置文件创建spring容器
public class SpringTest {
    @Autowired
    User u1;//自动注入注解 会在spring中根据类型查询数据存入对象
    @Autowired
    ComboPooledDataSource c3p0;
    @Autowired
    DruidDataSource druid;


    @Test
    public void u1(){
        System.out.println(u1);
    }

    @Test
    public void c3p0() throws SQLException {
        Connection connection = c3p0.getConnection();
        System.out.println(connection);
    }

    @Test
    public void druid() throws SQLException {
        Connection connection = druid.getConnection();
        System.out.println(connection);
    }
}