package com.phi.chapter07;

public class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println(this.getName() + ": 야옹");
	}

	public Cat() {
		this.setName("야옹이");
	}
}
