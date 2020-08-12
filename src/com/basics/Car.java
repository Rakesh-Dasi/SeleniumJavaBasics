package com.basics;

public class Car {
	
	private String type = "vehicle";
	
	public static int wheels = 4;
	
	public String color = "White";
	
	String fuel = "Petrol";
	
	
	public String getFuel() {
		return fuel;
	}
	
	protected void seats() {
		int seat =4;
		System.out.println("Car seats = " + seat);
	}

}
