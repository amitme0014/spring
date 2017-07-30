package com.igate.aop;

import java.sql.Connection;



public class BusinessImpl implements Business{
	
	
	public void doBusiness() {
            System.out.println("I do what I do best, i.e sleep.");
            try {
         
                 Thread.sleep(200);
                 
            } catch (InterruptedException e) {
                    System.out.println("How dare you to wake me up?");
            }
            System.out.println("Done with sleeping.");
    }
    
	
    public void myBusinessMethod()
    {
    	System.out.println("In My BusinessMethod");
    }
    
  

}