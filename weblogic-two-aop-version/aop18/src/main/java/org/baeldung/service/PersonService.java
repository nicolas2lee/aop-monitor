package org.baeldung.service;

import org.baeldung.performancemonitor.Person;

/**
 * Created by xinrui on 26/07/2017.
 */

public interface PersonService {
    public String getFullName(Person person);

    public int getAge(Person person);

}

