package com.yj.demo_ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.demo_ssmp.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<Person> {

}
