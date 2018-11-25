package com.dataaccess;

import lombok.ToString;
import lombok.Value;



@Value
@ToString()
public class User {

    private String id;

    private String name;

    private int age;


    public static void main(String[] args) {


        System.out.println(new User("a","b",12));
    }

    void f(){
        System.out.println("f()");
    }

}
