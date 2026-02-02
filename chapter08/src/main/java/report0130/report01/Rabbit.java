package report0130.report01;

import lombok.Getter;

@Getter
public class Rabbit {
	private String name;
	private String owner;
	private final String species = "RABBIT";

	public Rabbit(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
}
