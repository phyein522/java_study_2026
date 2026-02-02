package report0130.report02;

import lombok.Getter;

@Getter
public class Cat extends Animal {
	public Cat(String name, String owner) {
		super(name, owner, "CAT");
	}
}
