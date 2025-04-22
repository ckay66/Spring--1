package org.example.aop;

public class Target {
    public void selectAll(){
        System.out.println("selectAll run......");
    }
    public void selectById(int id){
        System.out.println("selectById run......");
    }
    public int add(int a,int b){
        //System.out.println(1/0);
        return a+b;
    }
}