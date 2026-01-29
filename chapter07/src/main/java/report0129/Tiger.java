package report0129;

public class Tiger extends Animal {
	public Object eat(Animal obj) {
		if(obj instanceof Rabbit) {
			System.out.println(this.getSpecies() + "가 " + obj.getSpecies() + "을/를 먹습니다.");
			return new String[] {"poo", "bone"};
		} else {
			System.out.println(this.getSpecies() + "는 " + obj.getSpecies() + "을/를 먹지 않습니다.");
			return "";
		}
	}

	@Override
	public void breathe() {
		System.out.println("Tiger가 숨을 쉽니다.");
	}

	public void sound() {
		System.out.println(this.getSpecies() + ": 어흥");
	}

	public Tiger() {
		this(0);
	} public Tiger(String gender) {
		this(0, gender);
	} public Tiger(int age) {
		this(age, "");
	} public Tiger(int age, String gender) {
		this.species = "Tiger";
		this.gender = switch(gender) {
			case "woman", "Woman", "WOMAN", "female", "Female", "FEMALE", "암컷", "여", "여자" -> Animal.WOMAN;
			default -> Animal.MAN;
		};
		this.age = age;
	}
}
