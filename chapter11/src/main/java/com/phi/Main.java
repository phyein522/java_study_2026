package com.phi;

public class Main {
	public static void main(String[] args) {
		Casher casher = new Casher();
		try {
			casher.calculMoney();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}