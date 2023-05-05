package com.yj.dao;

import com.yj.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String TABLE_NAME = "TEST.users";
    private final JdbcTemplate jdbcTemplate;
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void add(User user) {
        jdbcTemplate.update("UPSERT INTO " + TABLE_NAME + "(id, name, age) VALUES (?, ?, ?)",
                user.getId(), user.getName(), user.getAge());
    }

    @Override
    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM " + TABLE_NAME + " WHERE id = ?", id);
    }
    @Override
    public void update(User user) {
        jdbcTemplate.update("UPSERT INTO " + TABLE_NAME + "(id, name, age) VALUES (?, ?, ?)",
                user.getId(), user.getName(), user.getAge());
    }
    @Override
    public User get(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM " + TABLE_NAME + " WHERE id = ?",
                new Object[]{id},
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setAge(resultSet.getInt("age"));
                    return user;
                });
    }
}