package banking;

public class MachineNotWorkingException extends Exception {
//	public MachineNotWorkingException() {}
	public MachineNotWorkingException(String message) {
		super(message);
	}
}
