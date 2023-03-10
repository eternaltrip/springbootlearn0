package com.yj.springboot_cache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yj.springboot_cache.domain.Person;

import java.io.IOException;

public interface IPersonService extends IService<Person> {


    boolean getExcepton() throws IOException;

    Person cacheTest(Integer id);
}
