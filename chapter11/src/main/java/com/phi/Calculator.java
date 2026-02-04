package com.phi;

public class Calculator {
	public long add(int... arrs) {
		long result = 0;
		for(int a : arrs) {
			result += a;
		}
		return result;
	}

	public double divide(int... arrs) {
		//NullPointerException: null 넘김, ArrayIndexOutOfBoundsException: 아무것도 안넘김
		//Double.isInfinite() || Dounle.isNaN()
//		double result = 0.0;
//		try {
//			result = arrs[0];	//자동으로 (double)arrs[0]
//		} catch(NullPointerException e) {
//			System.out.println("매개값에 null이 전달됨");
//			return result;
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("매개값에 아무것도 전달되지 않음");
//			return result;
//		}
//		for(int i = 1; i < arrs.length; i++) {
//			double res = result / arrs[i];
//			System.out.println(result + " / " + arrs[i] + " = " + res);
//			if(Double.isInfinite(res) || Double.isNaN(res)) {
//				System.out.println("infinite || NaN : " + i);
//				continue;
//			}
//			result /= arrs[i];
//		}
//		return result;

		double result = arrs[0];
		for(int i = 1; i < arrs.length; i++) {
			result /= arrs[i];
		}
		return result;
	}
}
