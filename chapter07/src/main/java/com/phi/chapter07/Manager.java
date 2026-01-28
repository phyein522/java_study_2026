package com.phi.chapter07;

public non-sealed class Manager extends PersonSealed {
	@Override
	public void work() {
		System.out.println("생산 관리를 합니다.");
	}
}
