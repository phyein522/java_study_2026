package report0130.report02;

import lombok.Getter;

@Getter
public class Parrot extends Animal {
	public Parrot(String name, String owner) {
		super(name, owner, "PARROT");
	}
}
