/*
 * Copyright(C) 2013-2017 BaiduInc.ALL Rights Reserved.
 *
 * FileName: Person
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
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

