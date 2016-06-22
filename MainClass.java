package org.springaopexamples.client;

import org.springaopexamples.target.IBank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		IBank bank=(IBank)applicationContext.getBean("myBank");
		//bank.getBalance(23450043);
		bank.transfer(10002, 10001, 15000.00);
		
	}

}
