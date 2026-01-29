package report0129;

public class Swam extends Animal {
	public Object eat(Animal obj) {
		if(obj instanceof Rabbit || obj instanceof Tiger || obj instanceof Fox) {
			System.out.println(this.getSpecies() + "은 " + obj.getSpecies() + "을/를 먹지 않습니다.");
			return "";
		} else {
			System.out.println(this.getSpecies() + "이 " + obj.getSpecies() + "을/를 먹습니다.");
			return "poo";
		}
	}

	@Override
	public void breathe() {
		System.out.println("Swam이 숨을 쉽니다.");
	}

	public Swam() {
		this(0);
	} public Swam(String gender) {
		this(0, gender);
	} public Swam(int age) {
		this(age, "");
	} public Swam(int age, String gender) {
		this.species = "Swam";
		this.gender = switch(gender) {
			case "woman", "Woman", "WOMAN", "female", "Female", "FEMALE", "암컷", "여", "여자" -> Animal.WOMAN;
			default -> Animal.MAN;
		};
		this.age = age;
	}
}
