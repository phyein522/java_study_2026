package report0130.report04;

import lombok.Getter;

@Getter
public class Parrot extends Animal {
	public Parrot(String name, String owner) {
		super(name, owner, "PARROT");
	}
}
