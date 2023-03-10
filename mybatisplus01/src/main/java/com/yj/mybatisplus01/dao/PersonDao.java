package com.yj.mybatisplus01.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.mybatisplus01.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {

}
