package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {
	public int studentNo;

	public Student(String name, int studentNo) {
		super(name);
		this.setStudentNo(studentNo);
	}

	public void study() {
		System.out.println("공부를 합니다.");
	}
}
