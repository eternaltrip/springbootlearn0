package com.yj.demo_ssmp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yj.demo_ssmp.controller.base.BaseClass;
import com.yj.demo_ssmp.utils.ReturnObject;
import com.yj.demo_ssmp.domain.Person;
import com.yj.demo_ssmp.service.IPersonService;
import cn.yj.ip_spring_boot_starter.service.IpCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController  extends BaseClass {

    @Autowired
    private IPersonService personService;

    @Autowired
    private IpCountService ipCountService;

    @RequestMapping("/ok")
    public void ok(){
        ipCountService.count();
        logger.info("ok is ok...");
        log.info("log  ok is ok...");
    }


    @RequestMapping("/count")
    @ResponseBody
    public String count(){
        return  personService.count() +"";
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable String id){
        return  personService.getById(id);
    }


    @GetMapping("/{pageNum}/{pageSize}")
    public Page getById(@PathVariable int pageNum , @PathVariable int pageSize){
        Page page = new Page<Person>(pageNum,pageSize);
        return  page = personService.page(page);
    }

    @RequestMapping("/count1")
    @ResponseBody
    public ReturnObject count1(){
        return  ReturnObject.OK( personService.count()) ;
    }

    @RequestMapping("/exception")
    @ResponseBody
    public ReturnObject exception() throws IOException {
        personService.getExcepton();
        return  ReturnObject.OK( "123465") ;
    }


}
