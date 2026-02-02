package report0130.report01;

import lombok.Getter;

@Getter
public class Parrot {
	private String name;
	private String owner;
	private final String species = "PARROT";

	public Parrot(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
}
