package com.igate.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class BusinessDemo {
         public static void main(String[] args) {
                ApplicationContext context = new ClassPathXmlApplicationContext("business.xml");
                Business bc = (Business) context.getBean("myBusinessClass");
                
                bc.doBusiness();
                bc.myBusinessMethod();
                
                             
        }
}