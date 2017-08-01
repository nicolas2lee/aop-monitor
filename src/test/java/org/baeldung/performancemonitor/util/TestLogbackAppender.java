package org.baeldung.performancemonitor.util;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.Stack;

/**
 * Created by xinrui on 01/08/2017.
 */
public class TestLogbackAppender extends AppenderBase<ILoggingEvent> {
    private Stack<ILoggingEvent> events = new Stack<ILoggingEvent>();

    @Override
    protected void append(ILoggingEvent eventObject) {
        events.add(eventObject);
    }

    public void clear() {
        events.clear();
    }

    public ILoggingEvent getLastEvent() {
        return events.pop();
    }
}
