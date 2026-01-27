package com.phi.chapter07;

//@NoArgsConstructor	//파라미터가 하나도 없는 기본 생성자(default constructor)를 자동 생성
//@AllArgsConstructor	//클래스의 모든 필드를 파라미터로 받는 생성자를 자동 생성
public class Phone {
	public String model;
	public String color;

	public Phone() {
		System.out.println("Phone() 생성자 실행");
	}
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("Phone(String model, String color) 생성자 실행");
	}

	public void bell() {
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}

	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}

	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return this.model;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return this.color;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"model='" + this.getModel() + '\'' +
				", color='" + this.getColor() + '\'' +
				'}';
	}
}
