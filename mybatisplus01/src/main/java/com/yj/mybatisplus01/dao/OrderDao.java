package com.yj.mybatisplus01.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.mybatisplus01.domain.Order;
import com.yj.mybatisplus01.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
