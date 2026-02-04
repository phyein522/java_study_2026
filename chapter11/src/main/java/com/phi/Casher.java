package com.phi;

public class Casher {
	public void calculMoney() {
		Calculator cal = new Calculator();

		System.out.println(cal.divide(100, 1, 2, 0));
		System.out.println(cal.divide(0, 1, 2, 3));
		System.out.println(cal.divide(0, 0, 0));
		System.out.println(cal.divide());
		System.out.println(cal.divide(null));
	}
}
