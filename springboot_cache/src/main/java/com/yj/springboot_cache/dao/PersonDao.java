package com.yj.springboot_cache.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.springboot_cache.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {

}
