
package org.baeldung.performancemonitor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;

import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

import java.util.Date;

public class MyPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

    //private static final Logger LOGGER  = LoggerFactory.getLogger( MyPerformanceMonitorInterceptor.class.getName() );
    private static final Logger LOGGER = Logger.getLogger(PerfInterceptor.class);

    public MyPerformanceMonitorInterceptor() {
    }

    public MyPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log log) throws Throwable {

        String name = createInvocationTraceName(invocation);
        System.out.println("===========just a test");
        long start = System.currentTimeMillis();
        log.info("Method "+name+" execution started at:"+new Date());
        try {
            return invocation.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Method "+name+" execution lasted:"+time+" ms");
            log.info("Method "+name+" execution ended at:"+new Date());

            if (time > 10){
                log.warn("Method execution longer than 10 ms!");
            }

        }
    }
}