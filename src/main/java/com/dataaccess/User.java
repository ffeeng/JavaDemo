package com.dataaccess;

import lombok.Data;

@Data
public class User {

    private String id;

    private String name;

    private int age;


    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        user.setName("feng");
        System.out.println(user.toString());
    }

}
