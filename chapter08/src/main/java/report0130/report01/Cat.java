package report0130.report01;

import lombok.Getter;

@Getter
public class Cat {
	private String name;
	private String owner;
	private final String species = "CAT";

	Cat(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
}
