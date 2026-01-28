package com.phi.chapter07;

public class Director extends Manager {
	@Override
	public void work() {
		System.out.println(this. getName() + ": 제품을 기획합니다.");
	}

	public Director() {
		this.setName("기획");
	}
}
