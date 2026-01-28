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
		Scanner scanner = new Scanner(System.in);

		String name;
		do {
			System.out.print("\n이름 (1~100자): ");
			name = scanner.nextLine();
		} while(!isValid(name, "name"));
		this.setName(name);

		String major;
		do {
			System.out.print("\n학과 (1~100자): ");
			major = scanner.nextLine();
		} while(!isValid(major, "major"));
		this.setMajor(major);

		String number;
		do {
			System.out.print("\n학번 (10자리 숫자): ");
			number = scanner.nextLine();
		} while(!isValid(number, "number"));
		this.setNumber(Integer.parseInt(number));

		String birth;
		do {
			System.out.print("\n생년월일 (yyyy-MM-dd) (선택): ");
			birth = scanner.nextLine();
		} while(!birth.isBlank() && !isValid(birth, "birth"));
		this.setBirth(birth.isBlank() ? null : LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		String phone;
		do {
			System.out.print("\n전화번호 (010-0000-0000) (선택): ");
			phone = scanner.nextLine();
		} while(!phone.isBlank() && !isValid(phone, "phone"));
		this.setPhone(phone.isBlank() ? null : phone);

		String email;
		do {
			System.out.print("\n이메일 (선택): ");
			email = scanner.nextLine();
		} while(!email.isBlank() && !isValid(email, "email"));
		this.setEmail(email.isBlank() ? null : email);

		System.out.println(this.toString());
	}

	public void setTotalCredit(int totalCredit) { this.totalCredit = totalCredit; }
	public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }
	private void setName(String name) { this.name = name; }
	private void setMajor(String major) { this.major = major; }
	private void setNumber(int number) { this.number = number; }
	private void setBirth(LocalDate birth) { this.birth = birth; }
	private void setPhone(String phone) { this.phone = phone; }
	private void setEmail(String email) { this.email = email; }
	private void setLectures(Lecture[] lectures) { this.lectures = lectures; }

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
				if(!input.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
					System.out.println("이메일을 이메일 형식으로 입력해주세요.");
					return false;
				}
				break;
		}
		return true;
	}

	public void takeLecture() {
		Lecture[] newLectures = new Lecture[this.getLectures().length + 1];
		System.arraycopy(this.getLectures(), 0, newLectures, 0, this.getLectures().length);
		newLectures[this.getLectures().length] = new Lecture();
		this.setLectures(newLectures);
		int totalCredit = 0;
		double averageGrade = 0;
		for(Lecture lecture : this.getLectures()) {
			totalCredit += lecture.getGrade() == Lecture.F ? 0 : lecture.getCredit();
			averageGrade += lecture.getGrade();
		}
		this.setTotalCredit(totalCredit);
		this.setAverageGrade(averageGrade/this.getLectures().length);
		System.out.println(this.toString());
	}
}
