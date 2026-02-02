package report0130.report02;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AnimalPatient {
	private String name;	//자기 이름
	private String number;	//식별번호
	private String owner;	//주인 이름
	private String doctorInCharge;	//담당의
	private LocalDate hospitalizationDate;	//입원일
	private LocalDate dischargeDate;	//퇴원일
	private String species;	//종

	public final static String CAT = "CAT";
	public final static String PARROT = "PARROT";
	public final static String LARGE_DOG = "LARGE_DOG";
	public final static String SMALL_DOG = "SMALL_DOG";
	public final static String RABBIT = "RABBIT";

	public AnimalPatient(String name, String owner, String species, String doctorInCharge, LocalDate hospitalizationDate, LocalDate dischargeDate, String number) {
		this.name = name;
		this.owner = owner;
		this.species = species;
		this.doctorInCharge = doctorInCharge;
		this.hospitalizationDate = hospitalizationDate;
		this.dischargeDate = dischargeDate;
		this.number = number;
	}
}
