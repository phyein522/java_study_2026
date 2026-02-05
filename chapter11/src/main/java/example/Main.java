package example;

import example.exception.*;


public class Main {
	public static void doSomething(DrivingInterface di) {
		try {
			di.doSomething(4);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
		}
	}

	public static void TestDriving(Integer pedal) {
		System.out.println("TestDriving method");
		Driving driving = new Driving();
		try {
			driving.go(pedal);
			driving.go(4);
			driving.go(8);
			driving.stop(pedal);
			driving.stop(3);
			driving.stop(0);
		} catch (ParmeterNullException | DriverNullException | AvanteNullException ex ) {
			System.err.println(ex.toString());
		}

		try {
			driving.go(4);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
			driving.setLsh(new Driver("이승협"));
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
			driving.setAvanteMD(new Avante("MD7", "red"));
		}

		try {
			driving.go(8);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
			driving.setLsh(new Driver("이승협"));
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
			driving.setAvanteMD(new Avante("MD7", "red"));
		}

		try {
			driving.stop(pedal);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
			driving.setLsh(new Driver("이승협"));
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
			driving.setAvanteMD(new Avante("MD7", "red"));
		}

		try {
			driving.stop(3);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
			driving.setLsh(new Driver("이승협"));
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
			driving.setAvanteMD(new Avante("MD7", "red"));
		}

		try {
			driving.stop(0);
		} catch ( ParmeterNullException ex ) {
			System.err.println(ex.toString());
		} catch ( DriverNullException ex ) {
			System.err.println(ex.toString());
			driving.setLsh(new Driver("이승협"));
		} catch ( AvanteNullException ex ) {
			System.err.println(ex.toString());
			driving.setAvanteMD(new Avante("MD7", "red"));
		}

		doSomething(new DrivingInterface() {
			@Override
			public void doSomething(Integer pedal) throws ParmeterNullException, AvanteNullException, DriverNullException {
				driving.go(pedal);
			}
		});

		doSomething(new DrivingInterface() {
			@Override
			public void doSomething(Integer pedal) throws ParmeterNullException, AvanteNullException, DriverNullException {
				driving.go(4);
			}
		});

		doSomething(new DrivingInterface() {
			@Override
			public void doSomething(Integer pedal) throws ParmeterNullException, AvanteNullException, DriverNullException {
				driving.go(8);
			}
		});
	}


	public static void main(String[] args) {
		TestDriving(10);
	}
}
