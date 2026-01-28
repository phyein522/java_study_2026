package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PhoneAbstract {
	String owner;

	PhoneAbstract(String owner) {
		this.setOwner(owner);
	}

	void turnOn() {
		System.out.println(this.getOwner() + "의 폰 전원을 켭니다.");
	}
	void turnOff() {
		System.out.println(this.getOwner() + "의 폰 전원을 끕니다.");
	}
}
