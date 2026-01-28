package com.phi.chapter07;

public class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println(this.getName() + ": 멍멍");
	}

	public Dog() {
		this.setName("멍멍이");
	}
}
