package com.phi.exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	//exercise13, exercise14
	private String name;
	private String id;
	private String password;
	private int age;

	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
