package com.maths;

public class Division {

	public int divide(int first, int second) {
		int num=0;
		try {
			num = first / second;
		}catch(ArithmeticException e) {
			System.out.println("Cannot divide numer by zero");
		}
		return num;
	}

}
