package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task001TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-conf/applicationContext.xml");
		context.start();
	}
}
