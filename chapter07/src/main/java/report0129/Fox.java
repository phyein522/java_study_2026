package report0129;

public class Fox extends Animal {
	@Override
	public Object eat(Animal obj) {
		if(obj instanceof Rabbit || obj instanceof Swam) {
			System.out.println(this.getSpecies() + "가 " + obj.getSpecies() + "을/를 먹습니다.");
			return new String[] {"poo", "bone"};
		} else {
			System.out.println(this.getSpecies() + "는 " + obj.getSpecies() + "을/를 먹지 않습니다.");
			return "";
		}
	}

	@Override
	public void breathe() {
		System.out.println("Fox가 숨을 쉽니다.");
	}

	public void sound() {
		System.out.println(this.getSpecies() + ": 닝닝닝닝 닝닝닝닝");
	}

	public Fox() {
		this(0);
	} public Fox(String gender) {
		this(0, gender);
	} public Fox(int age) {
		this(age, "");
	} public Fox(int age, String gender) {
		this.species = "Fox";
		this.gender = switch(gender) {
			case "woman", "Woman", "WOMAN", "female", "Female", "FEMALE", "암컷", "여", "여자" -> Animal.WOMAN;
			default -> Animal.MAN;
		};
		this.age = age;
	}
}
