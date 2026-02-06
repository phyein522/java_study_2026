package com.phi;

public class Main {
	public static void main(String[] args) {
        UseObject uo1 = new UseObject("111", "abc");
		UseObject uo2 = new UseObject("111", new String("abc"));
		if(uo1.equals(uo2) && uo1.hashCode() == uo2.hashCode()) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		UseObject uo3 = (UseObject)uo1.clone();
		if(uo1.equals(uo3) && uo1.hashCode() == uo3.hashCode()) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		uo3.setName("aaa");
		System.out.println(uo3.getName() + ", " + uo1.getName());
	}
}