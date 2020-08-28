package com.lemon.pageobject;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/6 21:16
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(10);
        teacher.printName();
        teacher.printAge();
    }
}
