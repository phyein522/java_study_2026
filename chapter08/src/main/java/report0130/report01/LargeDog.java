package report0130.report01;

import lombok.Getter;

@Getter
public class LargeDog {
	private String name;
	private String owner;
	private final String species = "LARGE_DOG";

	public LargeDog(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}
}
