package report0129;

import lombok.Getter;

@Getter
public abstract class Animal {
	String species;	//종
	int age;
	int gender;

	public final static int MAN = 0;
	public final static int WOMAN = 1;

	public abstract Object eat(Animal obj);
	public abstract void breathe();

	public void poo(Object output) {
		if(output instanceof String poo) {
			if(!poo.isEmpty()) {
				System.out.println("배설물이 나왔습니다.");
			} else {
				System.out.println("배설물이 나오지 않았습니다.");
			}
		} else if(output instanceof String[] outputs) {
			System.out.println("배설물과 뼈가 나왔습니다.");
		}
	}

	public void sleep() {
		System.out.println("수면 중입니다.");
	}
}
