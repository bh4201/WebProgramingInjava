package com.cdac.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect //to declare a class(advisor) - contains
//repetitive task (cross cutting concern)- logging
@Component //to declare a spring bean
@Slf4j //lombok annotation to inject a logger field - "log"
public class CustomLoggingAspect {
 /*
  * Write a logging advice 
  *  - to intercept ANY request(before it reached ANY controller)
  *   , coming to this back end app
  *  - log the details
  *  - @Before
  */
	@Before("execution (* com.cdac.controller.*.*(..))")
	public void createLog(JoinPoint joinPoint) {
		log.info("------Intercepting requests before------{}", joinPoint);
	}
}
