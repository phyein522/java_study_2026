package com.phi;

public class Chapter08 {
	public void remoteControlExample() {
		System.out.println("\n\nRemoteControlExample");

		RemoteControl rc;

		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.setMute(false);
		rc.turnOff();

		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		rc.setMute(true);
		rc.setMute(false);

		System.out.println("리모콘 최대 볼륨: " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨: " + RemoteControl.MIN_VOLUME);

		RemoteControl.changeBattery();
	}

	public void serviceExample() {
		System.out.println("\n\nServiceExample");

		Service service = new ServiceImpl();
		service.defaultMethod1();
		service.defaultMethod2();
		Service.staticMethod1();
		Service.staticMethod2();
	}

	public void multiInterfaceImplExample() {
		System.out.println("\n\nMultiInterfaceImplExample");

		RemoteControl rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		Searchable searchable = new SmartTelevision();
		searchable.search("https://www.youtube.com");
	}

	public void extendsExample() {
		System.out.println("\n\nExtendsExample");

		InterfaceCImpl impl = new InterfaceCImpl();

		InterfaceA ia = impl;
		ia.methodA();

		InterfaceB ib = impl;
		ib.methodB();

		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

	public void promotionExample() {
		System.out.println("\n\nPromotionExample");

		IB b = new IB();
		IC c = new IC();
		ID d = new ID();
		IE e = new IE();

		IA a;
		a = b;
		a = c;
		a = d;
		a = e;
	}

	public void castingExample() {
		System.out.println("\n\nCastingExample");

		Vehicle vehicle = new Bus();
		vehicle.run();

		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();
	}

	public void carExample() {
		System.out.println("\n\nCarExample");

		Car myCar = new Car();
		myCar.run();

		myCar.setTire1(new KumhoTire());
		myCar.setTire2(new KumhoTire());
		myCar.run();
	}

	public void driverExample() {
		System.out.println("\n\nDriverExample");

		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus);
		driver.drive(taxi);
	}

	public void instanceofExample() {
		System.out.println("\n\nInstanceofExample");

		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		InstanceofExample.ride(taxi);
		InstanceofExample.ride(bus);
	}

	public void sealedExample() {
		System.out.println("\n\nSealedExample");

		SealedImplClass impl = new SealedImplClass();

		SealedInterfaceA ia = impl;
		ia.methodA();

		SealedInterfaceB ib = impl;
		ib.methodA();
		ib.methodB();

		SealedInterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
