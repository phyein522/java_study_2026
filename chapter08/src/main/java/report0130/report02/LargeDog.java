package report0130.report02;

import lombok.Getter;

@Getter
public class LargeDog extends Animal {
	public LargeDog(String name, String owner) {
		super(name, owner, "LARGE_DOG");
	}
}
