package com.basics;

public class Audi extends Car {

	public static void main(String[] args) {
		Audi a = new Audi();
		a.printDetails();

	}

	public void printDetails() {
		System.out.println("Whees of Audi Car is " + wheels);
	}

}
