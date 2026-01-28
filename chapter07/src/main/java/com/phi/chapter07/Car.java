package com.phi.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	public int speed;

	public void speedUp() {
		speed += 1;
	}

	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}

	public Tire tire;

	public void run() {
		tire.roll();
	}
}
