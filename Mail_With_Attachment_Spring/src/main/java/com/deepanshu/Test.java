package com.deepanshu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MailMail m=(MailMail)context.getBean("mailMail");
		String sender="sender@gmail.com";
		String reciever="reciever@gmail.com";
		m.sendMail(sender, reciever, "Testing MAil in SPring", "We are testing mail in spring");
		System.out.print("Success");
	}
}
