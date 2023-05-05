package com.yj.controller;

import com.yj.dao.UserDao;
import com.yj.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserDao userDao;
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    @PostMapping("/users")
    public void addUser() {
        User user =new User();
        user.setAge(11);
        user.setId("1");
        user.setName("qqq");
        userDao.add(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userDao.delete(id);
    }
    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userDao.update(user);
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userDao.get(id);
    }
}