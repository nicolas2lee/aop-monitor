package org.baeldung.performancemonitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.baeldung.service.PersonService;
import org.baeldung.service.impl.PersonServiceImpl;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {

    @Bean
    public Person person(){
        return new Person("John","Smith");
    }

    @Bean
    public PersonService personService(){
        return new PersonServiceImpl();
    }


    @Bean
    public PerfInterceptor myPerformanceMonitorInterceptor() {
        return new PerfInterceptor();
    }

    @Bean
    public Advisor myPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("org.baeldung.performancemonitor.AopPerformanceMonitorPointcut.entrypoint()");
        return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
    }

}