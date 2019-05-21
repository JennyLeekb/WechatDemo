package com.lkb.lambda.vo;

import lombok.Data;

/**
 * @Description 用户vo
 * @Author lkb
 * @CreateDate: 2019/5/21
 */
@Data
public class Person {

    //名称
    private String firstName;
    //姓氏
    private String lastName;
    //工作
    private String job;
    //性别
    private String gender;
    //工资
    private int salary;
    //年龄
    private int age;

    public Person(){

    }

    public Person(String firstName, String lastName, String job, String gender, int age, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
    }

}
