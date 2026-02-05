package report0205.report02;

public class BatteryLessThan5Exception extends Exception {
	public BatteryLessThan5Exception() {}
	public BatteryLessThan5Exception(String message) {
		super(message);
	}
}
