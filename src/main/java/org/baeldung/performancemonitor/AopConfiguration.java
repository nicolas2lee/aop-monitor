package org.baeldung.performancemonitor;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AopConfiguration {

    @Pointcut("execution(* org.baeldung.performancemonitor.PersonService.getFullName(..))")
    public void monitor() { }


    @Pointcut("execution(* org.baeldung.performancemonitor.PersonService.getAge(..))")
    public void myMonitor() { }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //pointcut.setExpression("org.baeldung.performancemonitor.AopConfiguration.monitor()");
        pointcut.setExpression("execution(* org.baeldung.performancemonitor.PersonService.getFullName(..))");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

    @Bean
    public Person person(){
        return new Person("John","Smith");
    }

    @Bean
    public PersonService personService(){
        return new PersonService();
    }

/*    @Bean
    public PerfInterceptor myPerformanceMonitorInterceptor() {
        return new PerfInterceptor();
        //return new MyPerformanceMonitorInterceptor(true);
    }*/

    @Bean
    public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
        //return new PerfInterceptor();
        return new MyPerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor myPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        //pointcut.setExpression("org.baeldung.performancemonitor.AopConfiguration.myMonitor()");
        pointcut.setExpression("execution(* org.baeldung.performancemonitor.PersonService.getAge(..))");
        return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
    }

}