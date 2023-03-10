package com.yj.springboot_jetcache.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.alicp.jetcache.anno.EnableCache;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yj.springboot_jetcache.dao.PersonDao;
import com.yj.springboot_jetcache.domain.Person;
import com.yj.springboot_jetcache.service.IPersonService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements IPersonService {

    @CreateCache(name="jetcache" , expire = 30 ,cacheType = CacheType.REMOTE)
    private Cache<String,Object> jetcCache;

    @CreateCache(name="jetcache" , expire = 30 ,cacheType = CacheType.LOCAL)
    private Cache<String,Object> jetcCache_local;


    @Override
    public boolean getExcepton() throws IOException {
        if(true) throw new IOException();
        return true;
    }


    //这里的缓存,可以在配置文件中设置缓存的时间.
//    @Cacheable(value = "cacheSpace" ,key = "#id")
    //使用 spEL 表达式来设置key的值,cacheTest[2]
//    @Cacheable(value = "cacheSpace" ,key = "#root.methodName + '[' + #id + ']'" , unless = " #id < 10 " ,condition = "#id >10 ")
    //unless 不缓存的值,condition要缓存的值,这里一般使用的时候,不会同时出现
//    @Cacheable(value = "cacheSpace" ,key = "#root.methodName + '[' + #id + ']'" , unless = " #id < 10 " ,condition = "#id >20 ")
    @Override
    public Person cacheTest(Integer id) {
        return baseMapper.selectById(id);
    }


    @Override
    public Person jetTest(String id) {
        System.out.println(id);
        Person person = null;
        person = (Person) jetcCache_local.get(id );
        if(person == null){
            person =  baseMapper.selectById(id);
            jetcCache_local.put(id  , person);
        }
        return person;
    }
}
