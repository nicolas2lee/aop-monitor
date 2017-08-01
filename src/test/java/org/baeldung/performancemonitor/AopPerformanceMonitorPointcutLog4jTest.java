package org.baeldung.performancemonitor;


import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

import org.baeldung.performancemonitor.util.TestAppender;
import org.baeldung.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Enumeration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xinrui on 01/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopPerformanceMonitorPointcutLog4jTest {

    //private final TestLogbackAppender appender =  new TestLogbackAppender();
    //private final Logger logger = Logger.getRootLogger();

    @Autowired
    PersonService personService;

    protected TestAppender testAppender;
    private final Logger root = Logger.getRootLogger();
    private Person person;

    @Before
    public void setUp() {
        this.person = new Person("Han", "Meimei");

        Appender appender = root.getAppender("org");

        Enumeration appenders = root.getAllAppenders();

        testAppender = (TestAppender) root.getAppender("org.baeldung.performancemonitor.PerfInterceptor");
/*        if (testAppender != null) {
            testAppender.
            testAppender.clear();
        }*/
    }

    @Test
    public void entrypoint() {
        personService.getFullName(this.person);
        List<LoggingEvent> loggingEvents = testAppender.getEventsList();
        LoggingEvent lastLoggingEvent = loggingEvents.get(loggingEvents.size()-1);

        assertThat(lastLoggingEvent.getMessage()).isEqualTo("perf monitor");
    }

    @After
    public void teardown(){
        //root.
        //root.detachAppender(testAppender);
    }

}