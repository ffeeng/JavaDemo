package com.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MybatisController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("getUsers")
    public List<User> getUsers(){
        return userMapper.getUsers();
    }


    @RequestMapping("getUser")
    public User getUser(int id){
        return userMapper.getUser(id);
    }

    @RequestMapping("updateUser")
    public boolean updateUser(User user){
        return userMapper.updateUser(user);
    }

    @RequestMapping("addUser")
    public boolean addUser(User user){
        return userMapper.addUser(user);
    }

    @RequestMapping("deleteUser")
    public boolean deleteUser(User user){
        return userMapper.deleteUser(user);
    }

}
