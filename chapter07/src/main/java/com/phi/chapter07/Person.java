package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
	public String name;

	public Person(String name) {
		this.setName(name);
	}

	public void walk() {
		System.out.println("걷습니다.");
	}
}
