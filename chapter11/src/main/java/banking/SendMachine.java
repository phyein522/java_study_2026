package banking;

public class SendMachine implements IMachine {
	//동작 여부 체크
	public boolean isActive() throws MachineNotWorkingException {
		if(Math.random() >= 0.3) {
			return true;
		} else {
			throw new MachineNotWorkingException("Machine broken !!");

		}
	}
}
