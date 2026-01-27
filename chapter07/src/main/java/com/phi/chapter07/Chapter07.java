package com.phi.chapter07;

import com.phi.chapter07.package1.*;
import com.phi.chapter07.package2.*;

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

		SmartPhone yourPhone = new SmartPhone();
		System.out.println(yourPhone.toString());
		yourPhone.setModel("아이폰");
		yourPhone.setColor("검정");
		yourPhone.setWifi(true);
		System.out.println("모델: " + yourPhone.getModel());
		System.out.println("색상: " + yourPhone.getColor());
		System.out.println("와이파이 상태: " + yourPhone.getWifi());
		System.out.println(yourPhone.toString());
	}
	public void computerExample() {
		System.out.println("\n\nComputerExample");

		int r = 10;

		Calculator calculator = new Calculator();
		System.out.println("원 면적: " + calculator.areaCircle(r) + "\n");

		Computer computer = new Computer();
		System.out.println("원 면적: " + computer.areaCircle(r));
	}
	public void supersonicAirplaneExample() {
		System.out.println("\n\nSupersonicAirplaneExample");

		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.setFlyMode(SupersonicAirplane.SUPERSONIC);
		sa.fly();
		sa.setFlyMode(SupersonicAirplane.NORMAL);
		sa.fly();
		sa.land();
	}
	public void promotionExample() {
		System.out.println("\n\nPromotionExample");

		InheritanceB b = new InheritanceB();
		InheritanceC c = new InheritanceC();
		InheritanceD d = new InheritanceD();
		InheritanceE e = new InheritanceE();

		InheritanceA a1 = b;
		InheritanceA a2 = c;
		InheritanceA a3 = d;
		InheritanceA a4 = e;

		InheritanceB b1 = d;
		InheritanceC c1 = e;
	}
	public void childExample() {
		System.out.println("\n\nChildExample");

		Child child = new Child();
		Parent parent = child;

		parent.method1();
		parent.method2();


		parent.field1 = "data1";
		child = (Child)parent;
		child.field2 = "data2";
		child.method3();
		System.out.println("field1: " + child.field1 + ", field2: " + child.field2);
	}
}
