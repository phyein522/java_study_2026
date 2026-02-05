package report0205;

import report0205.report01.*;
import report0205.report02.*;

public class Main {
	public static void main(String[] args) {
		Mjc813GameMachineV1 game = new Mjc813GameMachineV1(100, new MarioGame());
		try {
			game.runGame1();
		} catch(Game1IsNullException e) {
			System.err.println(e.getMessage());
		} catch(BatteryLessThan5Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
