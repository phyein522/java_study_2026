package example;

import example.exception.AvanteNullException;
import example.exception.DriverNullException;
import example.exception.ParmeterNullException;

public interface DrivingInterface {
	void doSomething(Integer pedal) throws ParmeterNullException, AvanteNullException, DriverNullException;
}
