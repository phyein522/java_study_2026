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
}
