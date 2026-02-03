package com.phi.machine;

public class Calculator {
	public long add(int... items) {
		long sum = 0;
		for(int num : items) {
			sum += num;
		}
		return sum;
	}
}
