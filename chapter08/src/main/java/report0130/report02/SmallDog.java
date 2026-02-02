package report0130.report02;

import lombok.Getter;

@Getter
public class SmallDog extends Animal {
	public SmallDog(String name, String owner) {
		super(name, owner, "SMALL_DOG");
	}
}
