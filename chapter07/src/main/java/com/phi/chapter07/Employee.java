package com.phi.chapter07;

public final class Employee extends PersonSealed {
	@Override
	public void work() {
		System.out.println(this.getName() + ": 제품을 생산합니다.");
	}

	public Employee() {
		this.setName("생산");
	}
}
