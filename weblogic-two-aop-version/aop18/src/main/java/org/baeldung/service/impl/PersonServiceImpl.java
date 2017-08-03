package org.baeldung.service.impl;

import org.baeldung.performancemonitor.Person;
import org.baeldung.service.PersonService;

public class PersonServiceImpl implements PersonService{

    public String getFullName(Person person) {
        return person.getLastName() + " " + person.getFirstName();
    }

    public int getAge(Person person) {

        return 100;
    }
}

