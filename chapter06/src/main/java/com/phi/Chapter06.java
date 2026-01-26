package com.phi;

public class Chapter06 {
	public void carExample1() {
		System.out.println("\n\nCarExample (1)");

		Car1 myCar = new Car1();
		System.out.println("모델명: " + myCar.model);
		System.out.println("시동여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
		//초기값 미제공 -> 객체 생성 시, 자동 초기화
	}
	public void carExample2() {
		System.out.println("\n\nCarExample (2)");

		Car2 myCar = new Car2();

		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);

		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}
	public void carExample3() {
		System.out.println("\n\nCarExample (3)");

		Car3 myCar = new Car3("그랜저", "검정", 250);
		System.out.println("new Car(\"그랜저\", \"검정\", 250)");

		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
	}
	public void koreanExample1() {
		System.out.println("\n\nKoreanExample (1)");

		Korean1 k1 = new Korean1("박자바", "011225-1234567");
		System.out.println("new Korean(\"박자바\", \"011225-1234567\")");
		System.out.println("k1.nation: " + k1.nation);
		System.out.println("k1.name: " + k1.name);
		System.out.println("k1.ssn: " + k1.ssn);

		Korean1 k2 = new Korean1("김자바", "930525-0654321");
		System.out.println("new Korean(\"김자바\", \"930525-0654321\")");
		System.out.println("k2.nation: " + k2.nation);
		System.out.println("k2.name: " + k2.name);
		System.out.println("k2.ssn: " + k2.ssn);
	}
	public void koreanExample2() {
		System.out.println("\n\nKoreanExample (2)");

		Korean2 k1 = new Korean2("박자바", "011225-1234567");
		System.out.println("new Korean(\"박자바\", \"011225-1234567\")");
		System.out.println("k1.nation: " + k1.nation);
		System.out.println("k1.name: " + k1.name);
		System.out.println("k1.ssn: " + k1.ssn);

		Korean2 k2 = new Korean2("김자바", "930525-0654321");
		System.out.println("new Korean(\"김자바\", \"930525-0654321\")");
		System.out.println("k2.nation: " + k2.nation);
		System.out.println("k2.name: " + k2.name);
		System.out.println("k2.ssn: " + k2.ssn);
	}
	public void carExample4() {
		System.out.println("\n\nCarExample (4)");

		Car4 car1 = new Car4();
		System.out.println("new Car()");
		System.out.println("car1.company: " + car1.company);
		System.out.println("car1.model: " + car1.model);
		System.out.println("car1.color: " + car1.color);
		System.out.println("car1.maxSpeed: " + car1.maxSpeed);
		System.out.println();

		Car4 car2 = new Car4("자가용");
		System.out.println("new Car(\"자가용\")");
		System.out.println("car2.company: " + car2.company);
		System.out.println("car2.model: " + car2.model);
		System.out.println("car2.color: " + car2.color);
		System.out.println("car2.maxSpeed: " + car2.maxSpeed);
		System.out.println();

		Car4 car3 = new Car4("자가용", "빨강");
		System.out.println("new Car(\"자가용\", \"빨강\")");
		System.out.println("car3.company: " + car3.company);
		System.out.println("car3.model: " + car3.model);
		System.out.println("car3.color: " + car3.color);
		System.out.println("car3.maxSpeed: " + car3.maxSpeed);
		System.out.println();

		Car4 car4 = new Car4("택시", "검정", 200);
		System.out.println("new Car(\"택시\", \"검정\", 200)");
		System.out.println("car4.company: " + car4.company);
		System.out.println("car4.model: " + car4.model);
		System.out.println("car4.color: " + car4.color);
		System.out.println("car4.maxSpeed: " + car4.maxSpeed);
	}
	public void carExample5() {
		System.out.println("\n\nCarExample (5)");

		Car5 car1 = new Car5("자가용");
		System.out.println("new Car(\"자가용\")");
		System.out.println("car1.company: " + car1.company);
		System.out.println("car1.model: " + car1.model);
		System.out.println("car1.color: " + car1.color);
		System.out.println("car1.maxSpeed: " + car1.maxSpeed);
		System.out.println();

		Car5 car2 = new Car5("자가용", "빨강");
		System.out.println("new Car(\"자가용\", \"빨강\")");
		System.out.println("car2.company: " + car2.company);
		System.out.println("car2.model: " + car2.model);
		System.out.println("car2.color: " + car2.color);
		System.out.println("car2.maxSpeed: " + car2.maxSpeed);
		System.out.println();

		Car5 car3 = new Car5("택시", "검정", 200);
		System.out.println("new Car(\"택시\", \"검정\", 200)");
		System.out.println("car3.company: " + car3.company);
		System.out.println("car3.model: " + car3.model);
		System.out.println("car3.color: " + car3.color);
		System.out.println("car3.maxSpeed: " + car3.maxSpeed);
	}
	public void calculatorExample1() {
		System.out.println("\n\nCalculatorExample (1)");

		Calculator1 myCalc = new Calculator1();

		myCalc.powerOn();

		int result1 = myCalc.plus(5, 6);
		System.out.println("myCalc.plus(5, 6): " + result1);

		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("myCalc.divide(10, 4): " + result2);

		myCalc.powerOff();
	}
	public void computerExample() {
		System.out.println("\n\nComputerExample");

		Computer myCom = new Computer();

		int result1 = myCom.sum(1, 2, 3);
		System.out.println("myCom.sum(1, 2, 3): " + result1);

		int result2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("myCom.sum(1, 2, 3, 4, 5): " + result2);

		int[] values = {1, 2, 3, 4, 5};
		int result3 = myCom.sum(values);
		System.out.println("myCom.sum(new int[] {1, 2, 3, 4, 5}): " + result3);

		int result4 = myCom.sum(new int[] {1, 2, 3, 4, 5});
		System.out.println("myCom.sum(new int[] {1, 2, 3, 4, 5}): " + result4);
	}
	public void carExample6() {
		System.out.println("\n\nCarExample (6)");

		Car6 myCar = new Car6();

		myCar.setGas(5);
		if(myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas를 주입하세요.");
	}
	public void calculatorExample2() {
		System.out.println("\n\nCalculatorExample (2)");

		Calculator2 myCalc = new Calculator2();
		double result1 = myCalc.areaRectangle(10);
		double result2 = myCalc.areaRectangle(10, 20);
		System.out.println("myCalc.areaRectangle(10): " + result1);
		System.out.println("myCalc.areaRectangle(10, 20): " + result2);
	}

	public void carExample7() {
		System.out.println("\n\nCarExample (7)");

		Car7 myCar = new Car7("포르쉐");
		Car7 yourCar = new Car7("벤츠");

		myCar.run();
		yourCar.run();
	}
	public void calculatorExample3() {
		System.out.println("\n\nCalculatorExample (3)");

		double result1 = 10 * 10 * Calculator3.pi;
		int result2 = Calculator3.plus(10, 5);
		int result3 = Calculator3.minus(10, 5);

		System.out.println("10 * 10 * Calculator.pi: " + result1);
		System.out.println("Calculator.plus(10, 5): " + result2);
		System.out.println("Calculator.minus(10, 5): " + result3);
	}
	public void televisionExample() {
		System.out.println("\n\nTelevisionExample");

		System.out.println(Television.info);
	}
	public void car8() {
		System.out.println("\n\nCar (8)");

		Car8.simulate();

		Car8 myCar = new Car8();
		myCar.speed = 60;
		myCar.run();
	}
	public void koreanExample3() {
		System.out.println("\n\nKoreanExample (3)");

		Korean3 k1 = new Korean3("123456-1234567", "김자바");

		System.out.println("k1.nation: " + k1.nation);
		System.out.println("k1.ssn: " + k1.ssn);
		System.out.println("k1.name: " + k1.name);

		k1.name = "김자바";
	}
	public void earthExample() {
		System.out.println("\n\nEarthExample");

		System.out.println("지구의 반지름: " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적: " + Earth.EARTH_SURFACE_AREA + "km^2");
	}
	public void car9() {
		System.out.println("\n\nCar (9)");

		com.phi.hyundai.Car9 car9 = new com.phi.hyundai.Car9();
	}
	public void carExample10() {
		System.out.println("\n\nCarExample (10)");

		Car10 myCar = new Car10();

		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());

		myCar.setSpeed(60);
		System.out.println("현재 속도: " + myCar.getSpeed());

		System.out.println("isStop(): " + myCar.isStop());
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도: " + myCar.getSpeed());
		System.out.println("isStop(): " + myCar.isStop());
	}
	public void singletonExample() {
		System.out.println("\n\nSingletonExapmle");

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체입니다.");
		} else {
			System.out.println("다른 Singleton 객체입니다.");
		}

		System.out.println("obj1: " + obj1);
		System.out.println("obj2: " + obj2);
	}
}