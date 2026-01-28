package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartPhoneAbstract extends PhoneAbstract {
	SmartPhoneAbstract(String owner) {
		super(owner);
	}

	void internetSearch() {
		System.out.println(this.getOwner() + "이/가 인터넷 검색을 합니다.");
	}
}
