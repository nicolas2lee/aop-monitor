package org.baeldung.performancemonitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by xinrui on 26/07/2017.
 */

@Aspect
@EnableAspectJAutoProxy
public class AopPerformanceMonitorPointcut {
    @Pointcut("execution(* org.baeldung.service.impl.PersonServiceImpl.getFullName(..))")
    public void monitor() { }


    @Pointcut("execution(* org.baeldung.service.impl.PersonServiceImpl.getAge(..))")
    public void myMonitor() { }

    @Pointcut("org.baeldung.performancemonitor.AopPerformanceMonitorPointcut.myMonitor() || org.baeldung.performancemonitor.AopPerformanceMonitorPointcut.monitor()")
    public void entrypoint() { }


}
