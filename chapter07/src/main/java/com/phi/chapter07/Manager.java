package com.phi.chapter07;

public non-sealed class Manager extends PersonSealed {
	@Override
	public void work() {
		System.out.println(this.getName() + ": 생산 관리를 합니다.");
	}

	public Manager() {
		this.setName("관리");
	}
}
