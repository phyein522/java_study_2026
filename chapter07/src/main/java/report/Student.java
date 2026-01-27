package report;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Getter
@ToString
public class Student {
	//student {이름, 학번, 학과, 생년월일, 전화번호, 이메일, 총학점, 평균학점}
	//takeLecture (수강)
	private String name;
	private String major;
	private int number;
	private LocalDate birth;
	private String phone;
	private String email;
	private int totalCredit = 0;
	private double averageGrade = 0;
	private Lecture[] lectures = new Lecture[0];

	public Student() {
		newStudent();
		System.out.println(this.toString());
	}

//	private Student(String name, String major, int number, LocalDate birth, String phone, String email) {
//		this.name = name;
//		this.major = major;
//		this.number = number;
//		this.birth = birth;
//		this.phone = phone;
//		this.email = email;
//	}

	public void setTotalCredit(int totalCredit) { this.totalCredit = totalCredit; }
	public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }
	private void setName(String name) { this.name = name; }
	private void setMajor(String major) { this.major = major; }
	private void setNumber(int number) { this.number = number; }
	private void setBirth(LocalDate birth) { this.birth = birth; }
	private void setPhone(String phone) { this.phone = phone; }
	private void setEmail(String email) { this.email = email; }
	private void setLectrues(Lecture[] lectures) { this.lectures = lectures; }

	private void newStudent() {
		Scanner scanner = new Scanner(System.in);

//		System.out.print("\n이름 (1~100자): ");
//		String name = scanner.nextLine();
//		if(!isValid(name, "name")) { return null; }
		String name;
		do {
			System.out.print("\n이름 (1~100자): ");
			name = scanner.nextLine();
		} while(!isValid(name, "name"));
		this.setName(name);

//		System.out.print("\n학과 (1~100자): ");
//		String major = scanner.nextLine();
//		if(!isValid(major, "major")) { return null; }
		String major;
		do {
			System.out.print("\n학과 (1~100자): ");
			major = scanner.nextLine();
		} while(!isValid(major, "major"));
		this.setMajor(major);

//		System.out.print("\n학번 (10자리 숫자): ");
//		String numberString = scanner.nextLine();
//		if(!isValid(numberString, "number")) { return null; }
//		int number = Integer.parseInt(numberString);
		String number;
		do {
			System.out.print("\n학번 (10자리 숫자): ");
			number = scanner.nextLine();
		} while(!isValid(number, "number"));
		this.setNumber(Integer.parseInt(number));

//		System.out.print("\n생년월일 (yyyy-MM-dd) (선택): ");
//		String birthString = scanner.nextLine();
//		if(!birthString.isBlank() && !isValid(birthString, "birth")) { return null; }
//		LocalDate birth = birthString.isBlank() ? null : LocalDate.parse(birthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String birth;
		do {
			System.out.print("\n생년월일 (yyyy-MM-dd) (선택): ");
			birth = scanner.nextLine();
		} while(!birth.isBlank() && !isValid(birth, "birth"));
		this.setBirth(birth.isBlank() ? null : LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

//		System.out.print("\n전화번호 (010-0000-0000) (선택): ");
//		String phone = scanner.nextLine();
//		if(!phone.isBlank() && !isValid(phone, "phone")) { return null; }
//		phone = phone.isBlank() ? null : phone;
		String phone;
		do {
			System.out.print("\n전화번호 (010-0000-0000) (선택): ");
			phone = scanner.nextLine();
		} while(!phone.isBlank() && !isValid(phone, "phone"));
		this.setPhone(phone.isBlank() ? null : phone);

//		System.out.print("\n이메일 (선택): ");
//		String email = scanner.nextLine();
//		if(!email.isBlank() && !isValid(email, "email")) { return null; }
//		phone = email.isBlank() ? null : email;
		String email;
		do {
			System.out.print("\n이메일 (선택): ");
			email = scanner.nextLine();
		} while(!email.isBlank() && !isValid(email, "email"));
		this.setEmail(email.isBlank() ? null : email);

//		Student student = new Student(name, major, number, birth, phone, email);
//		return student;
	}

	private static boolean isValid(String input, String check) {
		switch(check) {
			case "name":
			case "major":
				if(input == null || input.isBlank() || input.length() > 100) {
					System.out.print(check.equals("name") ? "이름을" : "학과를");
					System.out.println(" 1~100글자 범위로 입력하세요.");
					return false;
				}
				break;
			case "number":
				if(!input.matches("[0-9]{10}")) {
					System.out.println("학번을 10자리 숫자로 입력하세요.");
					return false;
				}
				break;
			case "birth":
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate.parse(input, formatter);
				} catch (DateTimeParseException e) {
					System.out.println("날짜를 yyyy-MM-dd 형식으로 입력해주세요.");
					return false;
				}
				break;
			case "phone":
				if(!input.matches("010-[0-9]{4}-[0-9]{4}")) {
					System.out.println("전화번호를 010-0000-0000 형식으로 입력해주세요.");
					return false;
				}
				break;
			case "email":
				if(!input.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$")) {
					System.out.println("이메일을 이메일 형식으로 입력해주세요.");
					return false;
				}
				break;
		}
		return true;
	}

	public void takeLecture() {
		Lecture newLecture = new Lecture();
		Lecture[] newLectures = new Lecture[this.getLectures().length + 1];
//		int i;
//		int totalCredit = 0;
//		for(i = 0; i < this.getLectures().length; i++) {
//			newLectures[i] = this.getLectures()[i];
//			totalCredit += newLectures[i].getCredit();
//		}
//		newLectures[i] = newLecture;
//		totalCredit += newLectures[i].getCredit();
//		this.setLectrues(newLectures);
//		this.setTotalCredit(totalCredit);
//		this.setAverageGrade((double)totalCredit/this.getLectures().length);
		System.arraycopy(this.getLectures(), 0, newLectures, 0, this.getLectures().length);
		newLectures[this.getLectures().length] = newLecture;
		this.setLectrues(newLectures);
		int totalCredit = 0;
		for(Lecture lecture : this.getLectures()) {
			totalCredit += lecture.getCredit();
		}
		this.setTotalCredit(totalCredit);
		this.setAverageGrade((double)totalCredit/this.getLectures().length);
		System.out.println(this.toString());
	}
}
