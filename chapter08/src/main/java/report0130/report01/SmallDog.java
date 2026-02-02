package report0130.report01;

import lombok.Getter;

@Getter
public class SmallDog {
	private String name;
	private String owner;
	private final String species = "SMALL_DOG";

	public SmallDog(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
}
