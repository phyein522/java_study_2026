package report0130.report02;

import lombok.Getter;

@Getter
public class Rabbit extends Animal {
	public Rabbit(String name, String owner) {
		super(name, owner, "RABBIT");
	}
}
