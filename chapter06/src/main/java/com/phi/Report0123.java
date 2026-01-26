package com.phi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

public class Report0123 {
	public static void main(String[] args) {
		System.out.println();

		Phone s25 = new Phone("s25", 350, 1000, 60, 20);
		Phone i14Pro = new Phone("iPhone 14 Pro", 400, 1000, 5, 10);
		s25.camera();
		i14Pro.camera();
		s25.call();
		i14Pro.call();
		s25.message();
		i14Pro.message();

		System.out.println();

		Game kirby = new Game("Kirby", "ADVENTURE", "12", 80000, "https://");
		kirby.print();

		System.out.println();

		GameCharacter warrior = new GameCharacter("James", "Warrior", "male", "2026-01-23", 100, 50, 5, 1, 3, 1);
		GameCharacter magician = new GameCharacter("Alice", "Magician", "female", "2026-01-23", 50, 100, 1, 5, 1, 3);
		warrior.print();
		magician.print();
		warrior.attack(magician);
		magician.magicAttack(warrior);
		magician.item();
	}
}

class Phone {
	private String name;
	private int[] pixel = new int[2];
	private int callOut;
	private int messageBox;

	Phone(String name, int pixelWidth, int pixelHeight, int callOut, int messageBox) {
		this.name = name;
		this.pixel[0] = pixelWidth;
		this.pixel[1] = pixelHeight;
		this.callOut = callOut;
		this.messageBox = messageBox;
	}

	public void camera() {
		System.out.println(this.name + "으로 " + this.pixel[0] + "X" + this.pixel[1] + " pixel 사진을 찍었습니다.");
	}
	void call() {
		System.out.println(this.name + "으로 전화를 겁니다.");
		for(int i = 0; i < this.callOut; i++) {
			System.out.print("전화 거는 중...  ");
			if(i == 10) {
				System.out.println("\n상대가 전화를 받았습니다.");
				return;
			}
		}
		System.out.println("\n상대가 " + this.callOut + "초 안에 전화를 받지 않았습니다.");
	}
	void message() {
		System.out.println(this.name + "에는 현재 " + this.messageBox + "개의 메시지가 보관되어 있습니다.");
	}
}

class Game {
	private String name;
	private String genre;
	private String grade;
	private int price;
	private String url;

	Game(String name, String genre, String grade, int price, String url) {
		this.name = name;
		this.genre = genre;
		this.grade = grade;
		this.price = price;
		this.url = url;
	}

	String getName() {
		return this.name;
	}
	String getGenre() {
		return this.genre;
	}
	String getGrade() {
		return this.grade;
	}
	String getPrice() {
		return Integer.toString(this.price);
	}
	String getUrl() {
		return this.url;
	}

	void print() {
		System.out.println("게임 이름: " + this.getName());
		System.out.println("장르: " + this.getGenre());
		System.out.println("등급: " + this.getGrade());
		System.out.println("가격: " + this.getPrice());
		System.out.println("이미지 주소: " + this.getUrl());
	}
}

class GameCharacter {
	private String name;
	private String job;
	private String gender;
//	private String birth;
	private LocalDate birth;
	private int hp;
	private int mp;
	private int strc;
	private int intc;
	private int dexc;
	private int luxc;

	GameCharacter(String name, String job, String gender, String birth, int hp, int mp, int strc, int intc, int dexc, int luxc) {
		this.name = name.length() < 1 || name == null ? "unknown" : name.length() > 10 ? name.substring(0, 10) : name;
		this.job = switch(job) {
			case "warrior", "Warrior", "WARRIOR" -> "WARRIOR";
			case "magician", "Magician", "MAGICIAN" -> "MAGICIAN";
			default -> "unknown";
		};
		this.gender = switch(gender){
			case "man", "male", "Man", "MAN", "Male", "MALE" -> "MAN";
			case "woman", "female", "Woman", "WOMAN", "Female", "FEMALE" -> "WOMAN";
			default -> "unknown";
		};
//		this.birth = birth;
		try {
			this.birth = LocalDate.parse(birth);
		} catch(DateTimeParseException e) {
			this.birth = LocalDate.now(ZoneId.of("Asia/Seoul"));
		}
		this.hp = hp < 0 ? 0 : hp;
		this.mp = mp < 0 ? 0 : mp;
		this.strc = strc < 1 ? 1 : strc;
		this.intc = intc < 1 ? 1 : intc;
		this.dexc = dexc < 1 ? 1 : dexc;
		this.luxc = luxc < 1 ? 1 : luxc;
	}

	String getName() {
		return this.name;
	}
	int getHp() {
		return this.hp;
	}
	int getMp() {
		return this.mp;
	}
	int getStrc() {
		return this.strc;
	}
	int getIntc() {
		return this.intc;
	}
	String getJob() {
		return this.job;
	}
	String getGender() {
		return this.gender;
	}
	String getBirth() {
		return this.birth.toString();
	}
	int getDexc() {
		return this.dexc;
	}
	int getLuxc() {
		return this.luxc;
	}

	void setHp(int hp) {
		this.hp = hp;
		if(this.hp < 0) {
			this.hp = 0;
		}
	}
	void setMp(int mp) {
		this.mp = mp;
	}

	void attack(GameCharacter target) {
		if(target.getHp() == 0) {
			System.out.printf("%s의 HP는 이미 0이다.\n", target.getName());
			return;
		}
		System.out.printf("%s가 %s에게 공격!\n", this.getName(), target.getName());
		System.out.printf("%s는 %d의 피해를 받았다.\n", target.getName(), this.getStrc());
		target.setHp(target.getHp() - this.getStrc());
		System.out.printf("%s의 HP: %d\n", target.getName(), target.getHp());
		System.out.println();
	}
	void magicAttack(GameCharacter target) {
		if(this.getMp() - 10 < 0) {
			System.out.printf("%s의 MP가 부족하다.\n", this.getName());
			return;
		}
		if(target.getHp() == 0) {
			System.out.printf("%s의 HP는 이미 0이다.\n", target.getName());
			return;
		}
		System.out.printf("%s가 %s에게 마법 공격!\n", this.getName(), target.getName());
		System.out.printf("%s는 %d의 피해를 받았다.\n", target.getName(), this.getIntc());
		target.setHp(target.getHp() - this.getIntc());
		System.out.printf("%s의 HP: %d\n", target.getName(), target.getHp());
		this.setMp(this.getMp() - 10);
		System.out.printf("%s의 MP: %d\n", this.getName(), this.getMp());
		System.out.println();
	}
	void item(int hp, int mp) {
		this.setHp(this.getHp() + hp);
		this.setMp(this.getMp() + mp);
		System.out.printf("%s는 아이템을 사용했다!\n", this.getName());
		System.out.printf("%s의 HP: %d, MP: %d\n", this.getName(), this.getHp(), this.getMp());
		System.out.println();
	} void item() {
		this.item(10, 10);
	}

	void print() {
		System.out.println("이름: " + this.getName());
		System.out.println("직업: " + this.getJob());
		System.out.println("성별: " + this.getGender());
		System.out.println("생년월일: " + this.getBirth());
		System.out.printf("HP: %d \tMP: %d \n", this.getHp(), this.getMp());
		System.out.printf("STR: %d \tINT: %d \tDEX: %d \tLUX: %d \n", this.getStrc(), this.getIntc(), this.getDexc(), this.getLuxc());
		System.out.println();
	}
}