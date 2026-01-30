package report0127;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@Getter
@ToString
public class StudentForApp {
	//student {이름, 학번, 학과, 생년월일, 전화번호, 이메일, 총학점, 평균학점}
	//takeLecture (수강)
	private String name;	//이름
	private String major;	//전공(학과)
	private int number;	//학번
	private LocalDate birth;	//생년월일
	private String phone;	//전화번호 (선택)
	private String email;	//이메일 (선택)
	private int totalCredit = 0;	//총학점
	private double averageGrade = 0;	//평균성적
	private ArrayList<LectureForApp> lectures = new ArrayList<LectureForApp>(0);	//수강한 강의

	public StudentForApp(String name, String major, int number, LocalDate birth, String phone, String email) {
		this.name = name;
		this.major = major;
		this.number = number;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
	}

	public void setTotalCredit(int totalCredit) { this.totalCredit = totalCredit; }
	public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }
	private void setBirth(LocalDate birth) { this.birth = birth; }
	private void setPhone(String phone) { this.phone = phone; }
	private void setEmail(String email) { this.email = email; }

	public static boolean isValid(String input, String check) {
		switch(check) {
			case "name":
			case "major":
				if(input == null || input.isBlank() || input.length() > 100) { return false; }
				break;
			case "number":
				if(!input.matches("[0-9]{10}")) { return false; }
				break;
			case "birth":
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate.parse(input, formatter);
				} catch (DateTimeParseException e) { return false; }
				break;
			case "phone":
				if(!input.matches("010-[0-9]{4}-[0-9]{4}")) { return false; }
				break;
			case "email":
				if(!input.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) { return false; }
				break;
		}
		return true;
	}

	public void addLecture(String subject, int credit, double grade, String takeDate, String divide) {
		this.getLectures().add(new LectureForApp(subject, credit, grade, takeDate, divide));
	}
}
