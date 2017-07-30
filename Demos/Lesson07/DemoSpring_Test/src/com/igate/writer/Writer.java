package com.igate.writer;

public class Writer implements IWriter{
	int number;
	public int writer(int i) {
		System.out.println(i+number);
		return number+i;		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
