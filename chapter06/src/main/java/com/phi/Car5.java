package com.phi;

public class Car5 {
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
