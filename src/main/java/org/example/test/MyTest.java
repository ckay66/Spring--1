package org.example.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyTest {
    @Test
    public void druidSpring() throws SQLException {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        DruidDataSource druid = (DruidDataSource) applicationContext.getBean("druid");
        Connection connection = druid.getConnection();
        System.out.println(connection);
        connection.close();
        applicationContext.close();
    }
    @Test
    public void c3p0Spring() throws SQLException {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        ComboPooledDataSource c3p0 = (ComboPooledDataSource) applicationContext.getBean("c3p0");
        Connection connection = c3p0.getConnection();
        System.out.println(connection);
        connection.close();
        applicationContext.close();
    }
    @Test
    public void druidTest() throws Exception {
        //我们已经手动配置; c3p0与druid连接池 但是配置的参数相同
        //如果修改需要依次修改 在实际开发中应该统一配置 我们一般会将数据库的参数
        //书写在jdbc.properties中 使用时 通过读取配置文件进行配置 而不是直接书写
        //java中提供了各种读取properties的工具类
        //ResourceBundle自动读取类路径下指定名称的properties配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");

        //使用无参构造方法创建数据源对象
        DruidDataSource druid=new DruidDataSource();
        //使用setter方法设置连接属性
        druid.setDriverClassName(rb.getString("jdbc.driver"));
        druid.setUrl(rb.getString("jdbc.url"));
        druid.setUsername(rb.getString("jdbc.username"));
        druid.setPassword(rb.getString("jdbc.password"));
        //使用数据源获取连接对象
        Connection connection = druid.getConnection();
        System.out.println(connection);
        //归还连接 关闭连接池
        connection.close();
        druid.close();
    }
    @Test
    public void c3p0Test() throws Exception {
        //我们已经手动配置; c3p0与druid连接池 但是配置的参数相同
        //如果修改需要依次修改 在实际开发中应该统一配置 我们一般会将数据库的参数
        //书写在jdbc.properties中 使用时 通过读取配置文件进行配置 而不是直接书写
        //java中提供了各种读取properties的工具类
        //ResourceBundle自动读取类路径下指定名称的properties配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");

        //使用无参构造方法创建数据源对象
        ComboPooledDataSource c3p0=new ComboPooledDataSource();
        //使用setter方法设置连接属性
        c3p0.setDriverClass(rb.getString("jdbc.driver"));
        c3p0.setJdbcUrl(rb.getString("jdbc.url"));
        c3p0.setUser(rb.getString("jdbc.username"));
        c3p0.setPassword(rb.getString("jdbc.password"));
        //使用数据源获取连接对象
        Connection connection = c3p0.getConnection();
        System.out.println(connection);
        //归还连接 关闭连接池
        connection.close();
        c3p0.close();
    }
    @Test
    public void druid() throws Exception {
        //使用无参构造方法创建数据源对象
        DruidDataSource druid=new DruidDataSource();
        //使用setter方法设置连接属性
        druid.setDriverClassName("com.mysql.jdbc.Driver");
        druid.setUrl("jdbc:mysql:///test");
        druid.setUsername("root");
        druid.setPassword("123456");
        //使用数据源获取连接对象
        Connection connection = druid.getConnection();
        System.out.println(connection);
        //归还连接 关闭连接池
        connection.close();
        druid.close();
    }
    @Test
    public void c3p0() throws Exception {
        //使用无参构造方法创建数据源对象
        ComboPooledDataSource c3p0=new ComboPooledDataSource();
        //使用setter方法设置连接属性
        c3p0.setDriverClass("com.mysql.jdbc.Driver");
        c3p0.setJdbcUrl("jdbc:mysql:///test");
        c3p0.setUser("root");
        c3p0.setPassword("123456");
        //使用数据源获取连接对象
        Connection connection = c3p0.getConnection();
        System.out.println(connection);
        //归还连接 关闭连接池
        connection.close();
        c3p0.close();
    }

    @Test
    public void u1(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Object u1 = applicationContext.getBean("u1");
        System.out.println(u1);
        applicationContext.close();
    }

}