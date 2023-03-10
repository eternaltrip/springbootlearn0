package com.yj.springboot_jetcache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yj.springboot_jetcache.domain.Person;

import java.io.IOException;

public interface IPersonService extends IService<Person> {


    boolean getExcepton() throws IOException;

    Person cacheTest(Integer id);

    Person jetTest(String id);

}
