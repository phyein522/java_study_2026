package report0129;

public class Rabbit extends Animal {
	public Object eat(Animal obj) {
		if(obj instanceof Swam) {
			System.out.println(this.getSpecies() + "이 " + obj.getSpecies() + "을/를 먹습니다.");
			return "poo";
		} else {
			System.out.println(this.getSpecies() + "은 " + obj.getSpecies() + "을/를 먹지 않습니다.");
			return "";
		}
	}

	@Override
	public void breathe() {
		System.out.println("Rabbit이 숨을 쉽니다.");
	}

	public Rabbit() {
		this(0);
	} public Rabbit(String gender) {
		this(0, gender);
	} public Rabbit(int age) {
		this(age, "");
	} public Rabbit(int age, String gender) {
		this.species = "Rabbit";
		this.gender = switch(gender) {
			case "woman", "Woman", "WOMAN", "female", "Female", "FEMALE", "암컷", "여", "여자" -> Animal.WOMAN;
			default -> Animal.MAN;
		};
		this.age = age;
	}

	public void jumping() {
		System.out.println(this.getSpecies() + "이 뛰어다닙니다.");
	}
}
