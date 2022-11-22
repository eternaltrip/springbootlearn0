package com.yj.demo_ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yj.demo_ssmp.dao.PersonDao;
import com.yj.demo_ssmp.domain.Person;
import com.yj.demo_ssmp.service.IPersonService;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao , Person> implements IPersonService  {

    @Override
    public boolean getExcepton() throws IOException {
        if(true) throw new IOException();
        return true;
    }

}
