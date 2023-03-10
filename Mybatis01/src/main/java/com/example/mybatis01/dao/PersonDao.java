package com.example.mybatis01.dao;

import com.example.mybatis01.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface PersonDao {


    @Select("select * from person_a where id = #{id}")
    public  Person getById(String id);

    @Select("select count(*) from person_a ")
    public  int count();
}
