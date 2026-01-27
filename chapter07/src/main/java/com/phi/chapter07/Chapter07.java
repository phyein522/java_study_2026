package com.phi.chapter07;

public class Chapter07 {
	public void smartPhoneExample() {
		System.out.println("\n\nSmartPhoneExample");

		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

		System.out.println("모델: " + myPhone.getModel());
		System.out.println("색상: " + myPhone.getColor());

		System.out.println("와이파이 상태: " + myPhone.getWifi());

		System.out.println(myPhone.toString());

		myPhone.bell();
		myPhone.sendVoice("여보세요.");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("아~ 네, 반갑습니다.");
		myPhone.hangUp();

		myPhone.setWifi(true);
		System.out.println("와이파이 상태: " + myPhone.getWifi());
		myPhone.internet();

		System.out.println(myPhone.toString());
	}
}
