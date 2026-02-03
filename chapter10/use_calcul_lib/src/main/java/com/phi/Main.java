package com.phi;

import com.mjc_0203.machine.Calculator;

public class Main {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		long n = cal.add(1, 2, 3, 4, 5);
		System.out.println(n);

		n = cal.add(1, 2, 4, 8, 16);
		System.out.println(n);
	}
}