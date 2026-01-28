package com.phi.chapter07;

import lombok.Getter;

@Getter
public class Person {
	public String name;

	public Person(String name) {
		this.name = name;
	}

	public void walk() {
		System.out.println("걷습니다.");
	}
}
