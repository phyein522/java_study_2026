package report0130.report02;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Getter
public class Nurse {
	private AnimalPatient[] animalPatients = new AnimalPatient[0];
	private int[][] counter = new int[0][2];	//tookMedicine, visited

	public Nurse() {
//		this.startWork();
	}

	private void setAnimalPatients(AnimalPatient[] animalPatients) {
		this.animalPatients = animalPatients;
	}
	private void setCounter(int[][] counter) {
		this.counter = counter;
	}

	public void record(Animal animal) {
		if(animal == null) {
			return;
		}

		String name = animal.getName();
		String owner = animal.getOwner();
		String species = animal.getSpecies();
		if(containAnimal(name, owner, species)) {
			System.out.println("해당 환자는 이미 기록됐습니다.");
			return;
		}
		if(switch(species) {
			case AnimalPatient.CAT, AnimalPatient.PARROT, AnimalPatient.LARGE_DOG, AnimalPatient.SMALL_DOG, AnimalPatient.RABBIT -> false;
			default -> true;
		}) {
			System.out.println("해당 동물 병원은 고양이, 앵무새, 대형견, 소형견, 토끼 동물 환자만 받습니다.");
		}

		Scanner scanner = new Scanner(System.in);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String hospitalizationDateString;
		LocalDate hospitalization = LocalDate.now();
		do {
			System.out.print("입원일 (yyyy-MM-dd):  ");
			hospitalizationDateString = scanner.nextLine();
			try {
				hospitalization = LocalDate.parse(hospitalizationDateString, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("입원일을 yyyy-MM-dd 형태로 입력하세요.");
				hospitalizationDateString = "";
			}
		} while(hospitalizationDateString.isBlank());

		String dischargeDateString;
		LocalDate dischargeDate = LocalDate.now();
		do {
			System.out.print("퇴원일 (yyyy-MM-dd):  ");
			dischargeDateString = scanner.nextLine();
			try {
				dischargeDate = LocalDate.parse(dischargeDateString, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("퇴원일을 yyyy-MM-dd 형태로 입력하세요.");
				dischargeDateString = "";
			}
		} while(dischargeDateString.isBlank());

		String doctorInCharge;
		do {
			System.out.print("담당 의사:  ");
			doctorInCharge = scanner.nextLine();
		} while(doctorInCharge.isBlank());
		if(doctorInCharge.length() > 100) {
			doctorInCharge = doctorInCharge.substring(0, 99);
		}

		String number = String.valueOf(this.getAnimalPatients().length);

		AnimalPatient animalPatient = new AnimalPatient(name, owner, species, doctorInCharge, hospitalization, dischargeDate, number);
		addAnimalPatient(animalPatient);
}

	public void addAnimalPatient(AnimalPatient animalPatient) {
		AnimalPatient[] newAnimalPatients = new AnimalPatient[this.getAnimalPatients().length + 1];
		System.arraycopy(this.getAnimalPatients(), 0, newAnimalPatients, 0, this.getAnimalPatients().length);
		newAnimalPatients[this.getAnimalPatients().length] = animalPatient;
		this.setAnimalPatients(newAnimalPatients);

		int[][] newCounter = new int[this.getCounter().length + 1][2];
		System.arraycopy(this.getCounter(), 0, newCounter, 0, this.getCounter().length);
		this.setCounter(newCounter);
	}

	public void takeMedicine() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 혹은 식별번호:  ");
		String input = scanner.nextLine();
		int index = this.findIndex(input);
		if(index < 0) {
			System.out.println(input + "은/는 존재하지 않는 환자입니다.");
			return;
		}

		String name = this.getAnimalPatients()[index].getName();
		if(this.getCounter()[index][0] >= 3) {
			System.out.println(name + " 환자는 이미 약을 3번 먹었습니다.");
			return;
		}

		this.getCounter()[index][0]++;
		System.out.println(name + "환자에게 약을 먹였습니다. (오늘 약을 먹인 횟수: " + this.getCounter()[index][0] + ")");
	}

	public void visit() {
		Scanner scanner = new Scanner(System.in);

		String timeString;
		LocalTime time = LocalTime.now();
		do {
			System.out.print("면회 시간 (HH:mm, 15:00~20:00):  ");
			timeString = scanner.nextLine();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				time = LocalTime.parse(timeString, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("면회 시간을 HH:mm 형식으로 입력해주세요.");
				timeString = "";
			}
		} while(timeString.isBlank());
		if(time.isBefore(LocalTime.of(15, 0)) || time.isAfter(LocalTime.of(20, 0))) {
			System.out.println("면회 시간은 15시~20시까지입니다.");
			return;
		}

		System.out.print("이름 혹은 식별번호:  ");
		String input = scanner.nextLine();
		int index = this.findIndex(input);
		if(index < 0) {
			System.out.println(input + "은/는 존재하지 않는 환자입니다.");
			return;
		}

		String name = this.getAnimalPatients()[index].getName();
		if(this.getCounter()[index][1] >= 1) {
			System.out.println(name + " 환자는 이미 면회를 했습니다.");
			return;
		}

		this.getCounter()[index][1]++;
		System.out.println(name + "환자가 면회를 했습니다. (오늘 면회한 횟수: " + this.getCounter()[index][1] + ")");
	}

	public int findIndex(String input) {
		int index = -1;
		try {
			index = Integer.parseInt(input);	//입력값이 식별번호
		} catch(NumberFormatException e) {
			for(int i = 0; i < this.getAnimalPatients().length; i++) {
				if(this.getAnimalPatients()[i].getName().equals(input)) {	//입력값이 이름
					index = i;
					break;
				}
			}
		}
		return index;
	}

	public boolean containAnimal(String name, String owner, String species) {
		for(AnimalPatient animalPatient : this.getAnimalPatients()) {
			if(animalPatient.getName().equals(name) && animalPatient.getOwner().equals(owner) && animalPatient.getSpecies().equals(species)) {
				return true;
			}
		}
		return false;
	}

	public void printAnimalPatientsList() {
		for(AnimalPatient animalPatient: this.getAnimalPatients()) {
			System.out.printf("환자 이름: %s \t", animalPatient.getName());
			System.out.printf("주인 이름: %s \t", animalPatient.getOwner());
			System.out.printf("종: %s \t", animalPatient.getSpecies());
			System.out.printf("담당 의사: %s \t", animalPatient.getDoctorInCharge());
			System.out.printf("입원일: %s \t", animalPatient.getHospitalizationDate());
			System.out.printf("퇴원일: %s \t", animalPatient.getDischargeDate());
			System.out.printf("식별 번호: %s \t\n", animalPatient.getNumber());
		}
	}
}
