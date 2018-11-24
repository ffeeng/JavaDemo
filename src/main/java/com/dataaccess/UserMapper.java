package com.dataaccess;

import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper {

    @Select("select * from user")
    @Results({ @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age") })
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    @Results({ @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age") })
    User getUser(int id);

    @Update("update user set name=#{name},age=#{age} where id = #{id}")
    boolean updateUser(User user);

    @Insert("insert into user(name,age) values(#{name},#{age})")
    boolean addUser(User user);

    @Delete("delete from user where id = #{id}")
    boolean deleteUser(User user);
}
