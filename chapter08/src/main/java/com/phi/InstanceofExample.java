package com.phi;

public class InstanceofExample {
	public static void ride(Vehicle vehicle) {
		if(vehicle instanceof Bus bus) {
			bus.checkFare();
		}
		vehicle.run();
	}
}
