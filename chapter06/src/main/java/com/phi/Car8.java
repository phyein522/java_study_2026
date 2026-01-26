package com.phi;

public class Car8 {
	int speed;

	void run() {
		System.out.println(speed + "으로 달립니다.");
	}

	static void simulate() {
		Car8 myCar = new Car8();
		myCar.speed = 200;
		myCar.run();
	}
}
