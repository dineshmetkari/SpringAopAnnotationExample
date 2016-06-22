package org.springaopexamples.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionAspect {

	@Pointcut("execution(* org.springaopexamples.target.BankImpl.transfer(..))")
	public void dummyTransferPointcut(){
		
	}
	
	@Around("dummyTransferPointcut()")
	public void transferTransaction(ProceedingJoinPoint processJp){
		System.out.println("before processing transfer.....");
		
		try {
			
			processJp.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("after processing transfer ......");
	}
	
	public void depositTransaction(ProceedingJoinPoint processJp,long accountno, double amount){

		System.out.println("before deposit........");
		System.out.println("Parameters passing:accountno="+accountno+" and amount= "+amount);
		try {
			processJp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after deposit......");
	}
}
