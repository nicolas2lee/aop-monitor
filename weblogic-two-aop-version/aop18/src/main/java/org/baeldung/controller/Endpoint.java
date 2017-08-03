package org.baeldung.controller;

import org.baeldung.performancemonitor.Person;
import org.baeldung.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xinrui on 03/08/2017.
 */
@RestController
public class Endpoint {
    @Autowired
    PersonService personService;

    @GetMapping("/welcome")
    public String restEndpoint(){
        Person person = new Person("test1", "test2");
        System.out.println("Name is:"+ personService.getFullName(person));
        System.out.println("Age is:"+ personService.getAge(person));
        return "ok";
    }
}
