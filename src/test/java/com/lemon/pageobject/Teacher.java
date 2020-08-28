package com.lemon.pageobject;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/6 21:14
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class Teacher {
    private int id;
    public Teacher(int id){
        this.id=id;
    }
    private String name="歪歪";
    private int age=30;

    public void printName(){
        System.out.println(id+name);
    }

    public void printAge(){
        System.out.println(id+age);
    }
}
