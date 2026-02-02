package report0130.report04;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Getter
public class Nurse {
	private AnimalPatient[][] animalPatients = new AnimalPatient[7][0];
//	private int[][] counter = new int[0][2];	//tookMedicine, visited
	private int[][] takeMedicineCounter = new int[7][0];
	private int[][] visitCounter = new int[7][0];
	private int[][] feedCounter = new int[7][0];

	public Nurse() {
//		this.startWork();
	}

	private void setAnimalPatientsRoom(AnimalPatient[] animalPatients, int index) {
		this.animalPatients[index] = animalPatients;
	}
	private void setTakeMedicineCounter(int[] takeMedicineCounter, int index) {
		this.takeMedicineCounter[index] = takeMedicineCounter;
	}
	private void setVisitCounter(int[] visitCounter, int index) {
		this.visitCounter[index] = visitCounter;
	}
	private void setFeedCounter(int[] feedCounter, int index) {
		this.feedCounter[index] = feedCounter;
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
			case AnimalPatient.CAT, AnimalPatient.PARROT, AnimalPatient.LARGE_DOG, AnimalPatient.SMALL_DOG, AnimalPatient.RABBIT, AnimalPatient.CHICKEN, AnimalPatient.HEDGEHOG -> false;
			default -> true;
		}) {
			System.out.println("해당 동물 병원은 고양이, 앵무새, 대형견, 소형견, 토끼, 닭, 고슴도치 동물 환자만 받습니다.");
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

		int index = switch(animal.getSpecies()) {
			case AnimalPatient.CAT -> 0;
			case AnimalPatient.PARROT -> 1;
			case AnimalPatient.LARGE_DOG -> 2;
			case AnimalPatient.SMALL_DOG -> 3;
			case AnimalPatient.RABBIT -> 4;
			case AnimalPatient.CHICKEN -> 5;
			case AnimalPatient.HEDGEHOG -> 6;
			default -> -1;
		};
		String number = index + "-" + this.getAnimalPatients()[index].length;

		AnimalPatient animalPatient = new AnimalPatient(name, owner, species, doctorInCharge, hospitalization, dischargeDate, number);
		addAnimalPatient(animalPatient);
}

	public void addAnimalPatient(AnimalPatient animalPatient) {
		int index = switch(animalPatient.getSpecies()) {
			case AnimalPatient.CAT -> 0;
			case AnimalPatient.PARROT -> 1;
			case AnimalPatient.LARGE_DOG -> 2;
			case AnimalPatient.SMALL_DOG -> 3;
			case AnimalPatient.RABBIT -> 4;
			case AnimalPatient.CHICKEN -> 5;
			case AnimalPatient.HEDGEHOG -> 6;
			default -> -1;
		};

		AnimalPatient[] newAnimalPatients = new AnimalPatient[this.getAnimalPatients()[index].length + 1];
		System.arraycopy(this.getAnimalPatients()[index], 0, newAnimalPatients, 0, this.getAnimalPatients()[index].length);
		newAnimalPatients[this.getAnimalPatients()[index].length] = animalPatient;
		this.setAnimalPatientsRoom(newAnimalPatients, index);

		int[] newTakeMedicineCounter = new int[this.getTakeMedicineCounter()[index].length + 1];
		System.arraycopy(this.getTakeMedicineCounter()[index], 0, newTakeMedicineCounter, 0, this.getTakeMedicineCounter()[index].length);
		this.setTakeMedicineCounter(newTakeMedicineCounter, index);

		int[] newVisitCounter = new int[this.getVisitCounter()[index].length + 1];
		System.arraycopy(this.getVisitCounter()[index], 0, newVisitCounter, 0, this.getVisitCounter()[index].length);
		this.setVisitCounter(newVisitCounter, index);

		int[] newFeedCounter = new int[this.getFeedCounter()[index].length + 1];
		System.arraycopy(this.getFeedCounter()[index], 0, newFeedCounter, 0, this.getFeedCounter()[index].length);
		this.setFeedCounter(newFeedCounter, index);
	}

	public void takeMedicine() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름 혹은 식별번호:  ");
		String input = scanner.nextLine();
		int[] index = this.findIndex(input);
		if(index[0] < 0 || index[1] < 0) {
			System.out.println(input + "은/는 존재하지 않는 환자입니다.");
			return;
		}

		String name = this.getAnimalPatients()[index[0]][index[1]].getName();
		if(this.getTakeMedicineCounter()[index[0]][index[1]] >= 3) {
			System.out.println(name + " 환자는 이미 약을 3번 먹었습니다.");
			return;
		}

		this.getTakeMedicineCounter()[index[0]][index[1]]++;
		System.out.println(name + "환자에게 약을 먹였습니다. (오늘 약을 먹인 횟수: " + this.getTakeMedicineCounter()[index[0]][index[1]] + ")");
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

	public int[] findIndex(String input) {
		int[] index = {-1, -1};
		try {
			String[] numbers = input.split("-");
			index[0] = Integer.parseInt(numbers[0]);
			index[1] = Integer.parseInt(numbers[1]);
		} catch(NumberFormatException e) {
			for(AnimalPatient[] animalPatients : this.getAnimalPatients()) {
				for(AnimalPatient animalPatient : animalPatients) {
					if(animalPatient.getName().equals(input)) {
						String[] numbers = animalPatient.getNumber().split("-");
						index[0] = Integer.parseInt(numbers[0]);
						index[1] = Integer.parseInt(numbers[1]);
					}
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

	public void feed() {
		//time, int gram;
		Scanner scanner = new Scanner(System.in);

		String timeString;
		LocalTime time = LocalTime.now();
		do {
			System.out.print("사료 시간 (HH:mm):  ");
			timeString = scanner.nextLine();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				time = LocalTime.parse(timeString, formatter);
			} catch (DateTimeParseException e) {
				System.out.println("사료 시간을 HH:mm 형식으로 입력해주세요.");
				timeString = "";
			}
		} while(timeString.isBlank());

		String gramString;
		int gram = 0;
		do {
			System.out.print("사료량(g):  ");
			gramString = scanner.nextLine();
			try {
				gram = Integer.parseInt(gramString);
			} catch (NumberFormatException e) {
				System.out.println("사료량을 정수 형식으로 입력하세요.");
				gramString = "";
			}
		} while(gramString.isBlank());

		System.out.print("이름 혹은 식별번호:  ");
		String input = scanner.nextLine();
		int index = this.findIndex(input);
		if(index < 0) {
			System.out.println(input + "은/는 존재하지 않는 환자입니다.");
			return;
		}

		//사료
	}
}
