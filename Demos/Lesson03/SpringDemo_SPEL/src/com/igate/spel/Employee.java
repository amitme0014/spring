package com.igate.spel;

import java.util.ArrayList;

public class Employee {
	
	private int eid;
	private String enm;
	private double esl;
	private int eage;
	private City eCity;
	
	
	public City geteCity() {
		return eCity;
	}
	public void seteCity(City eCity) {
		this.eCity = eCity;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	private City ecity;
	
	private ArrayList<Course> crsList;
	public int getEid() {
		return eid;
	}
	public String getEnm() {
		return enm;
	}
	public double getEsl() {
		return esl;
	}
	public City getEcity() {
		return ecity;
	}
	public ArrayList<Course> getCrsList() {
		return crsList;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setEnm(String enm) {
		this.enm = enm;
	}
	public void setEsl(double esl) {
		this.esl = esl;
	}
	public void setEcity(City ecity) {
		this.ecity = ecity;
	}
	public void setCrsList(ArrayList<Course> crsList) {
		this.crsList = crsList;
	}
	
	

}
