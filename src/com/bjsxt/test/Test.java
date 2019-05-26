package com.bjsxt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.Airport;
import com.bjsxt.service.impl.AirportServiceImpl;

public class Test {
     public static void main(String[] args) {
    	 
		ApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[]  names=context.getBeanDefinitionNames();
//		for(String string:names){
//			System.out.println(string);
//		}
		AirportServiceImpl bean=context.getBean("airportService",AirportServiceImpl.class);
	    List<Airport> list=bean.show();
	    System.out.println(list);
      }
}
