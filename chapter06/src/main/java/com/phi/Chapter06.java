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
		System.out.println("k1.nation: " + k1.nation);
		System.out.println("k1.name: " + k1.name);
		System.out.println("k1.ssn: " + k1.ssn);

		Korean2 k2 = new Korean2("김자바", "930525-0654321");
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
}

class Car1 {
	String model;
	boolean start;
	int speed;
}

class Car2 {
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
}

class Car3 {
	String model;
	String color;
	int maxSpeed;

	Car3(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}

class Korean1 {
	String nation = "대한민국";
	String name;
	String ssn;

	public Korean1(String n, String s) {
		name = n;
		ssn = s;
	}
}

class Korean2 {
	String nation = "대한민국";
	String name;
	String ssn;

	public Korean2(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
}

class Car4 {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	Car4() {

	} Car4(String model) {
		this.model = model;
	} Car4(String model, String color) {
		this.model = model;
		this.color = color;
	} Car4(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}

class Car5 {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	Car5(String model) {
		this(model, "은색", 250);
	} Car5(String model, String color) {
		this(model, color, 250);
	} Car5(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}

class Calculator1 {
	void powerOn() {
		System.out.println("Calculator 전원을 켭니다.");
	}
	void powerOff() {
		System.out.println("Calculator 전원을 끕니다.");
	}
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	double divide(int x, int y) {
		double result = (double)x / y;
		return result;
	}
}

class Computer {
	int sum(int ...values) {
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}

class Car6 {
	int gas;

	void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}

	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다. (gas 잔량: " + gas + ")");
				gas--;
			} else {
				System.out.println("멈춤니다. (gas 잔량: " + gas + ")");
				return;
			}
		}
	}
}

class Calculator2 {
	double areaRectangle(double width) {
		return width * width;
	}
	double areaRectangle(double width, double height) {
		return width * height;
	}
}