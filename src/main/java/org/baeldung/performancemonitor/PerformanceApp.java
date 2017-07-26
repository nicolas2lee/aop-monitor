package org.baeldung.performancemonitor;

import org.baeldung.service.CoordinateService;
import org.baeldung.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PerformanceApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        Person person = (Person) context.getBean("person");
        PersonService personService = (PersonService) context.getBean("personService");

        Coordinate coordinate = (Coordinate) context.getBean("coordinate") ;
        CoordinateService coordinateService = (CoordinateService) context.getBean("coordinateService");
        System.out.println("Name is:"+ personService.getFullName(person));
        System.out.println("Age is:"+ personService.getAge(person));
        System.out.println("latitude is:"+ coordinateService.getLatitude(coordinate));
        System.out.println("longitude is:"+ coordinateService.getLongitude(coordinate));
    }
}