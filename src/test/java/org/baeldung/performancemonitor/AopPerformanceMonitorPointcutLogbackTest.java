package org.baeldung.performancemonitor;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.baeldung.performancemonitor.util.TestLogbackAppender;
import org.baeldung.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xinrui on 01/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopPerformanceMonitorPointcutLogbackTest {

    //private final TestLogbackAppender appender =  new TestLogbackAppender();
    //private final Logger logger = Logger.getRootLogger();

    @Autowired
    PersonService personService;

    protected TestLogbackAppender testAppender;
    private final Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    private Person person;

    @Before
    public void setUp() {
        this.person = new Person("Han", "Meimei");

        testAppender = (TestLogbackAppender) root.getAppender("TEST");
        if (testAppender != null) {
            testAppender.clear();
        }
    }

    @Test
    public void entrypoint() {
        personService.getFullName(this.person);
        ILoggingEvent lastEvent = testAppender.getLastEvent();
        assertThat(lastEvent.getMessage()).isEqualTo("perf monitor");
    }

    @After
    public void teardown(){
        root.detachAppender(testAppender);
    }

}