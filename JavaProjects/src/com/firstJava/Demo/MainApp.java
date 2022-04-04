package com.firstJava.Demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	   public static void main(String[] args) {
		   	  AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		   	  
		   	  // raise (publish) ContextSartedEvent event
		   	  context.start();
		   	  System.out.println();
		   	  
		      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		      System.out.println(objA.getMessage1());
		      System.out.println(objA.getMessage2());
		      
		      System.out.println();
		      // raise (publish) ContextStoppedEvent event
		      context.stop();
	   }
}