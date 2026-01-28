package com.phi.chapter07;

public abstract class PhoneAbstract {
	String owner;

	PhoneAbstract(String owner) {
		this.owner = owner;
	}

	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
