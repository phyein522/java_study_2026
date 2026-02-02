package report0130.report01;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class Main {
	private Object[] animals = new Object[0];

	public Main() {
		this.start();
	}

	public void printAnimalsList() {
		for(Object animal : animals) {
			String name;
			String owner;
			String species;
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
			} else {
				System.out.println("목록에 동물이 없습니다.");
				return;
			}
			System.out.printf("이름: %s \t", name);
			System.out.printf("주인 이름: %s \t", owner);
			System.out.printf("종: %s \t\n", species);
		}
	}

	public void addAnimal() {
		Scanner scanner = new Scanner(System.in);

		String species;
		do {
			System.out.print("종 (1: 고양이, 2: 앵무새, 3: 대형견, 4: 소형견, 5: 토끼):  ");
			species = switch(scanner.nextLine()) {
				case "1" -> AnimalPatient.CAT;
				case "2" -> AnimalPatient.PARROT;
				case "3" -> AnimalPatient.LARGE_DOG;
				case "4" -> AnimalPatient.SMALL_DOG;
				case "5" -> AnimalPatient.RABBIT;
				default -> "";
			};
		} while(species.isBlank());

		String name;
		do {
			System.out.print("이름:  ");
			name = scanner.nextLine();
		} while(name.isBlank());
		if(name.length() > 100) {
			name = name.substring(0, 99);
		}

		String owner;
		do {
			System.out.print("주인 이름:  ");
			owner = scanner.nextLine();
		} while(owner.isBlank());
		if(owner.length() > 100) {
			owner = owner.substring(0, 99);
		}

		switch(species) {
			case AnimalPatient.CAT:
				addAnimalList(new Cat(name, owner));
				break;
			case AnimalPatient.PARROT:
				addAnimalList(new Parrot(name, owner));
				break;
			case AnimalPatient.LARGE_DOG:
				addAnimalList(new LargeDog(name, owner));
				break;
			case AnimalPatient.SMALL_DOG:
				addAnimalList(new SmallDog(name, owner));
				break;
			case AnimalPatient.RABBIT:
				addAnimalList(new Rabbit(name, owner));
				break;
		}
	}

	public void addAnimalList(Object animal) {
		Object[] newAnimals = new Object[this.getAnimals().length + 1];
		System.arraycopy(this.getAnimals(), 0, newAnimals, 0, this.getAnimals().length);
		newAnimals[this.getAnimals().length] = animal;
		this.setAnimals(newAnimals);
	}

	private void setAnimals(Object[] animals) {
		this.animals = animals;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		Nurse nurse = new Nurse();
		while(true) {
			System.out.println("\n\n----------------------------------------------------------------------------------------------------");
			System.out.println("1. 환자 기록 | 2. 약 먹이기 | 3. 환자 면회 | 4. 환자 목록 확인 | 5. 종료 | 6. 동물 목록 | 7. 동물 추가");
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.print(">>  ");
			String select = scanner.nextLine();
			switch(select) {
				case "1":
					nurse.record(this.findAnimal());
					break;
				case "2":
					nurse.takeMedicine();
					break;
				case "3":
					nurse.visit();
					break;
				case "4":
					nurse.printAnimalPatientsList();
					break;
				case "5":
					System.out.println("종료합니다.");
					return;
				case "6":
					this.printAnimalsList();
					break;
				case "7":
					this.addAnimal();
					break;
			}
		}
	}

	public Object findAnimal() {
		Scanner scanner = new Scanner(System.in);

		String name;
		do {
			System.out.print("이름:  ");
			name = scanner.nextLine();
		} while(name.isBlank());
		if(name.length() > 100) {
			name = name.substring(0, 99);
		}

		String owner;
		do {
			System.out.print("주인 이름:  ");
			owner = scanner.nextLine();
		} while(owner.isBlank());
		if(owner.length() > 100) {
			owner = owner.substring(0, 99);
		}

		String species;
		do {
			System.out.print("종 (1: 고양이, 2: 앵무새, 3: 대형견, 4: 소형견, 5: 토끼):  ");
			species = switch(scanner.nextLine()) {
				case "1" -> AnimalPatient.CAT;
				case "2" -> AnimalPatient.PARROT;
				case "3" -> AnimalPatient.LARGE_DOG;
				case "4" -> AnimalPatient.SMALL_DOG;
				case "5" -> AnimalPatient.RABBIT;
				default -> "";
			};
		} while(species.isBlank());

		String getName = "";
		String getOwner = "";
		String getSpecies = "";
		for(Object animal : this.getAnimals()) {
			if(animal instanceof Cat cat) {
				getName = cat.getName();
				getOwner = cat.getOwner();
				getSpecies = cat.getSpecies();
			} else if(animal instanceof Parrot parrot) {
				getName = parrot.getName();
				getOwner = parrot.getOwner();
				getSpecies = parrot.getSpecies();
			} else if(animal instanceof LargeDog largeDog) {
				getName = largeDog.getName();
				getOwner = largeDog.getOwner();
				getSpecies = largeDog.getSpecies();
			} else if(animal instanceof SmallDog smallDog) {
				getName = smallDog.getName();
				getOwner = smallDog.getOwner();
				getSpecies = smallDog.getSpecies();
			} else if(animal instanceof Rabbit rabbit) {
				getName = rabbit.getName();
				getOwner = rabbit.getOwner();
				getSpecies = rabbit.getSpecies();
			}
			if(getName.equals(name) && getOwner.equals(owner) && getSpecies.equals(species)) {
				return animal;
			}
		}

		System.out.println("해당 동물은 목록에 없습니다.");
		return null;
	}

	public static void main(String[] args) {
//		new Nurse();
		new Main();
	}
}
