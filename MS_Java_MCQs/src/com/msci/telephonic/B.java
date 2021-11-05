package com.msci.telephonic;

public class B extends A {

	public B() {

	}

	//static methods are inherited but can't be overridden . Reimplementing it just hides parent class' method
	public static void print() {
		System.out.println("print1");
	}

	public static void main(String [] args) {
		print(); //static methods are visible in child class
	}


	//overridden method in child class can totally skip throwing exception even if it's thrown by parent class
	@Override
	public void method1(){

	}
	
	//If parent class doesn't throw Exception , child class can't do the same
	@Override
	public void method2() throws Exception{

	}

}
