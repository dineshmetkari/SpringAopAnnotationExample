package org.springaopexamples.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* org.springaopexamples.target.BankImpl.getBalance(*))")
	public void dummyBalancePointcut(){
		
	}
	
	@Before("dummyBalancePointcut()")
	public void logBefore(){
		System.out.println("Hi I am inside logBefore method");
		System.out.println("User is accessing Bank Operations...");
	}
	
	@After("dummyBalancePointcut()")
	public void logAfter(){
		System.out.println("Hi I am inside logAfter method");
	}
	
	public void logBeforeWithPointcutInfo(JoinPoint joinpoint){
		System.out.println("Calling..["+joinpoint.getTarget().getClass()+"]:["+joinpoint.getSignature()+"]");
	}

}
