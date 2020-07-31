/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: StudentInfo
 *
 * Description: xxxxx
 *
 * History:
 * 版本号    作者    日期    操作
 * 1.0    liushuaibiao 2020/7/30   x
 * ...
 */
package com.bdsoft.rpcaio.API;

import java.io.Serializable;

/**
 * @author liushuaibiao
 * @version 1.0
 * @date 2020/7/30
 * @see
 */
public class StudentInfo implements Serializable {
    private static  final long serialVersionUID = -605498797347398869L;
    private String name;
    private  int age;
    private  String sex;
    private  int size;

    public StudentInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", size=" + size +
                '}';
    }
}

