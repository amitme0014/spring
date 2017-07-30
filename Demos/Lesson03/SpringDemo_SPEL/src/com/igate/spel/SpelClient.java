package com.igate.spel;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("SpEL.xml");
		Employee e=(Employee)appContext.getBean("employee");
		
		System.out.println(e.getEid());
		System.out.println(e.getEnm());
		System.out.println(e.getEsl());
		System.out.println(e.getEage());
		City city=e.geteCity();
		System.out.println(city.getName());
		
		
		CityList cL=(CityList)appContext.getBean("cList");
		ArrayList<City> cList=cL.getCityList(); 
		
		for(City c:cList)
		{
			System.out.println(c.getName()+" "+c.getPopulation()+" "+c.getState());
		}

	}

}
