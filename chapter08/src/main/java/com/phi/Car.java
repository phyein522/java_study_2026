package com.phi;

public class Car {
	Tire tire1 = new HankookTire();
	Tire tire2 = new KumhoTire();

	public void run() {
		tire1.roll();
		tire2.roll();
	}

	public void setTire1(Tire tire1) {
		this.tire1 = tire1;
	}
	public void setTire2(Tire tire2) {
		this.tire2 = tire2;
	}
}
