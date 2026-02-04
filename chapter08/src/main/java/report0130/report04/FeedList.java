package report0130.report04;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class FeedList {
	private LocalTime time;
	private int gram;
	private AnimalPatient animalPatient;

	public FeedList(LocalTime time, int gram, AnimalPatient animalPatient) {
		this.time = time;
		this.gram = gram;
		this.animalPatient = animalPatient;
	}
}
