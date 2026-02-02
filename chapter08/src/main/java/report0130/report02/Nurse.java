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

	public void record(Object animal) {
		if(animal == null) {
			return;
		}

		String name = "";
		String owner = "";
		String species = "";
		if(animal instanceof Cat cat) {
			name = cat.getName();
			owner = cat.getOwner();
			species = cat.getSpecies();
		} else if(animal instanceof Parrot parrot) {
			name = parrot.getName();
			owner = parrot.getOwner();
			species = parrot.getSpecies();
		} else if(animal instanceof LargeDog largeDog) {
			name = largeDog.getName();
			owner = largeDog.getOwner();
			species = largeDog.getSpecies();
		} else if(animal instanceof SmallDog smallDog) {
			name = smallDog.getName();
			owner = smallDog.getOwner();
			species = smallDog.getSpecies();
		} else if(animal instanceof Rabbit rabbit) {
			name = rabbit.getName();
			owner = rabbit.getOwner();
			species = rabbit.getSpecies();
		}
		if(containAnimal(name, owner, species)) {
			System.out.println("해당 환자는 이미 기록됐습니다.");
			return;
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

		/*
		Scanner scanner = new Scanner(System.in);

		String name;
		do {
			System.out.print("환자 이름을 입력하세요:  ");
			name = scanner.nextLine();
		} while(name.isBlank());
		if(name.length() > 100) {
			name = name.substring(0, 99);
		}

		String owner;
		do {
			System.out.print("주인 이름을 입력하세요:  ");
			owner = scanner.nextLine();
		} while(owner.isBlank());
		if(owner.length() > 100) {
			owner = owner.substring(0, 99);
		}

		//고양이, 앵무새, 대형견, 소형견, 토끼
		String species;
		do {
			System.out.print("종을 입력하세요. (입원 가능 종: 고양이(CAT), 앵무새(PARROT), 대형견(LARGE_DOG), 소형견(SMALL_DOG), 토끼(RABBIT)):  ");
			species = scanner.nextLine();
			species = switch(species) {
				case "고양이", "cat", "Cat", "CAT" -> "CAT";
				case "앵무새", "parrot", "Parrot", "PARROT" -> "PARROT";
				case "대형견", "대형 견", "largedog", "large dog", "Largedog", "Large dog", "LargeDog", "Large Dog", "LARGEDOG", "LARGE DOG", "large_dog", "Large_dog", "Large_Dog", "LARGE_DOG", "bigdog", "big dog", "Bigdog", "Big dog", "BigDog", "Big Dog", "BIGDOG", "BIG DOG", "big_dog","Big_dog","Big_Dog", "BIG_DOG" -> "LARGE_DOG";
				case "소형견", "소형 견", "smalldog", "small dog", "Smalldog", "Small dog", "SmallDog", "Small Dog", "SMALLDOG", "SMALL DOG", "small_dog", "Small_dog", "Small_Dog", "SMALL_DOG" -> "SMALL_DOG";
				case "토끼", "rabbit", "Rabbit", "RABBIT" -> "RABBIT";
				default -> species;
			};
			if(!species.equals("CAT") && !species.equals("PARROT") && !species.equals("LARGE_DOG") && !species.equals("SMALL_DOG") && !species.equals("RABBIT")) {
				System.out.println("입원 가능 종은 고양이, 앵무새, 대형견, 소형견, 토끼 뿐입니다.");
				return;
			}
		} while(species.isBlank());

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
		*/
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
/*
	public void startWork() {
		System.out.println("출근합니다.");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\n\n--------------------------------------------------");
			System.out.println("1. 환자 기록 | 2. 약 먹이기 | 3. 환자 면회 | 4. 환자 목록 확인 | 5. 퇴근");
			System.out.println("--------------------------------------------------");
			System.out.print(">>  ");
			String select = scanner.nextLine();
			switch(select) {
				case "1":
					record();
					break;
				case "2":
					takeMedicine();
					break;
				case "3":
					visit();
					break;
				case "4":
					printAnimalPatientsList();
					break;
				case "5":
					System.out.println("퇴근합니다.");
					return;
			}
		}
	}
*/
}
