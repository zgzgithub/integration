package com.zgz.pojo;

import java.io.Serializable;

public class Test1 implements Serializable{

    private static final long serialVersionUID = 1L;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "age=" + age +
                '}';
    }
}
