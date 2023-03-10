package com.example.springboot_mongo;

import com.example.springboot_mongo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootMongoApplicationTests {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Person person = new Person();
        person.setAddress("大件路");
        person.setAge("16");
        person.setId("111");
        person.setName("杨大");
        mongoTemplate.save(person);
    }


    @Test
    void find() {
        List<Person> personList = (List<Person>) mongoTemplate.findAll(Person.class);
        System.out.println(personList);
    }



}
