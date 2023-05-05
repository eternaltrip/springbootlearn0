package com.yj.dao;

import com.yj.pojo.User;

public interface UserDao {
    void add(User user);
    void delete(String id);
    void update(User user);
    User get(String id);
}