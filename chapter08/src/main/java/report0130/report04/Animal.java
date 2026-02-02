package report0130.report04;

import lombok.Getter;

@Getter
public class Animal {
	private String name;
	private String owner;
	private String species;

	public Animal(String name, String owner, String species) {
		this.name = name;
		this.owner = owner;
		this.species = species;
	}
}
