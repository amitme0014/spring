package com.igate.aop;

public class BusinessImpl implements Business {
	 
    public void doBusiness() {
            System.out.println("I do what I do best, i.e sleep.");
            try {
            	throw new NullPointerException();
            } catch (Exception e) {
                    System.out.println("How dare you to wake me up?");
            }
            System.out.println("Done with sleeping.");
    }

	
}