package org.baeldung.performancemonitor.util;


import org.apache.log4j.AppenderSkeleton;
import org.slf4j.event.LoggingEvent;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinrui on 01/08/2017.
 */
public class TestAppender extends AppenderSkeleton {
    public List<LoggingEvent> getEventsList() {
        return eventsList;
    }

    private List<LoggingEvent> eventsList = new ArrayList();

    protected void append(LoggingEvent event) {
        eventsList.add(event);
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }


}
