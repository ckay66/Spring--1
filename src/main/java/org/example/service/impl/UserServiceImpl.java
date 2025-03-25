package org.example.service.impl;

import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("UserService save method running....");
    }
    public UserServiceImpl() {
        System.out.println("none");
    }
    public void a(){
        System.out.println("初始化方法");
    }
    public void b(){
        System.out.println("销毁方法");
    }
}