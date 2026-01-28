package com.phi.chapter07;

public class SmartPhoneAbstract extends PhoneAbstract {
	SmartPhoneAbstract(String owner) {
		super(owner);
	}

	void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
