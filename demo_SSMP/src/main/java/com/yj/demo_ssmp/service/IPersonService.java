package com.yj.demo_ssmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yj.demo_ssmp.domain.Person;

import java.io.IOException;

public interface IPersonService extends IService<Person> {


    boolean getExcepton() throws IOException;
}
