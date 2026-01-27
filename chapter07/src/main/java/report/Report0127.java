package report;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Report0127 {
	//lecture (과목) {과목명, 성적, 학점, 수강일(년도-학기), 구분(전공/교양)}
	//student {이름, 학번, 학과, 생년월일, 전화번호, 이메일, 총학점, 평균학점}
	//takeLecture (수강), grade (성적)
	String[] newStudent() {
		String[] student = new String[8];
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.print("이름: ");
			student[0] = scanner.nextLine();
			System.out.print("학과: ");
			student[1] = scanner.nextLine();
			System.out.print("학번: ");
			student[2] = scanner.nextLine();
			System.out.print("생년월일: ");
			student[3] = scanner.nextLine();
			System.out.print("전화번호: ");
			student[4] = scanner.nextLine();
			System.out.print("이메일: ");
			student[5] = scanner.nextLine();
		} catch(Exception e) {
			System.out.println("오류 발생");
		}
		return student;
	}

	boolean checkInput(String[] student, String check) {
		switch(check) {
			case "name":
				if(student[0].isEmpty()) {
					System.out.println("이름을 1글자 이상 입력하세요.");
					return false;
				}
				if(student[0].length() > 100) {
					System.out.println("이름은 100글자 이하로 입력하세요.");
				}
				break;
			case "major":
				if(student[1].isEmpty()) {
					System.out.println("학과를 입력하세요.");
					return false;
				}
				if(student[1].length() > 100) {
					System.out.println("학과명은 100글자 이하로 입력하세요.");
					return false;
				}
				break;
			case "number":
				if(student[2].isEmpty()) {
					System.out.println("학번을 입력하세요.");
					return false;
				}
				if(student[2].length() != 10) {
					System.out.println("학번은 10글자로 입력하세요.");
					return false;
				}
				break;
			case "birth":
				if(!student[3].isEmpty()) {
					try {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate.parse(student[3], formatter);
					} catch (DateTimeParseException e) {
						System.out.println("날짜는 yyyy-MM-dd 형식으로 입력해주세요.");
						return false;
					}
				}
				break;
			case "phone":
				if(student[4].length() != 13) {
					System.out.println("전화번호는 010-0000-0000 형식으로 입력해주세요.");
					return false;
				}
				if(!student[4].isEmpty() && !student[4].matches("(010|011|016)-\\d{4}-\\d{4}")) {
					System.out.println("전화번호는 010-0000-0000 형식으로 입력해주세요.");
					return false;
				}
				break;
			case "email":
				if(!student[5].isEmpty() && !student[5].matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.com$")) {
					System.out.println("이메일 형식으로 입력해주세요.");
					return false;
				}
				break;
		}

		return true;
	}
}
