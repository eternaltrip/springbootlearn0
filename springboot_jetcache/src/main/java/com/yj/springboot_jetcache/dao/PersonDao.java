package com.yj.springboot_jetcache.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.springboot_jetcache.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {

}
