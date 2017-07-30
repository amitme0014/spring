package com.igate.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BusinessProfiler {
 
        @Pointcut("execution(* com.igate.aop.*.d*(..))")
        public void businessMethods() { }
 
        @Around("businessMethods()")
        public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        	
        	   Object obj = pjp.getTarget();
        	   long start = System.currentTimeMillis();
               System.out.println("Going to call the method.");
               Object output=pjp.proceed();
               
               System.out.println("Method execution completed.");
               long elapsedTime = System.currentTimeMillis() - start;
               System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
               return output;
        }
        
        
        @Pointcut("execution(* com.igate.aop.*.my*(..))")
        public void beforeMethod(){ }
        
        @Before("beforeMethod()")
        public void MyBeforeMethod(){
        	System.out.println("Applying Before advice");
        }
      
}