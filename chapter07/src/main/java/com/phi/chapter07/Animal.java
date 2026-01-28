package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	public abstract void sound();

	public String name;
}
