package report;

import lombok.Getter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@ToString
public class Lecture {
	//lecture (과목) {과목명, 학점, 성적, 수강일(년도-학기), 구분 divide(전공 major/교양 refinement)}
	private String subject;
	private int credit;
	private int grade;
	private String takeDate;
	private String divide;

	private final static int A = 5;
	private final static int B = 4;
	private final static int C = 3;
	private final static int D = 2;
	private final static int E = 1;
	private final static int F = 0;

	public Lecture() {
		Scanner scanner = new Scanner(System.in);

		String subject;
		do {
			System.out.print("\n과목명 (1~100자): ");
			subject = scanner.nextLine();
		} while(!isValid(subject, "subject"));
		this.setSubject(subject);

		String credit;
		do {
			System.out.print("\n학점: ");
			credit = scanner.nextLine();
		} while(!isValid(credit, "credit"));
		this.setCredit(Integer.parseInt(credit));

		String grade;
		do {
			System.out.print("\n성적 (A~F): ");
			grade = scanner.nextLine();
		} while(!isValid(grade, "grade"));
		this.setGrade(switch(grade) {
			case "A", "a" -> A;
			case "B", "b" -> B;
			case "C", "c" -> C;
			case "D", "d" -> D;
			case "E", "e" -> E;
			default -> F;
		});

		String takeDate;
		do {
			System.out.print("\n수강일 (년도-학기, 예: 2000-3): ");
			takeDate = scanner.nextLine();
		} while(!isValid(takeDate, "takeDate"));
		this.setTakeDate(takeDate);

		String divide;
		do {
			System.out.print("\n구분 (전공(MAJOR)/교양(REFINEMENT): ");
			divide = scanner.nextLine();
		} while(!isValid(divide, "divide"));
		this.setDivide(switch(divide) {
			case "전공", "major", "Major", "MAJOR" -> "MAJOR";
			default -> "REFINEMENT";
		});

		System.out.println(this.toString());
	}

//	private Lecture(String subject, int credit, int grade, String takeDate, String divide) {
//		this.subject = subject;
//		this.credit = credit;
//		this.grade = grade;
//		this.takeDate = takeDate;
//		this.divide = divide;
//	}

	private void setSubject(String subject) { this.subject = subject; }
	private void setCredit(int credit) { this.credit = credit; }
	private void setGrade(int grade) { this.grade = grade; }
	private void setTakeDate(String takeDate) { this.takeDate = takeDate; }
	private void setDivide(String divide) { this.divide = divide; }

//	public static void newLecture() {
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("\n과목명 (1~100자): ");
//		String subject = scanner.nextLine();
//		if(!isValid(subject, "subject")) { return null; }
//
//		System.out.print("\n학점: ");
//		String creditString = scanner.nextLine();
//		if(!isValid(creditString, "credit")) { return null; }
//		int credit = Integer.parseInt(creditString);
//
//		System.out.print("\n성적 (A~F): ");
//		String gradeString = scanner.nextLine();
//		if(!isValid(gradeString, "grade")) { return null; }
//		int grade = switch(gradeString) {
//			case "A", "a" -> A;
//			case "B", "b" -> B;
//			case "C", "c" -> C;
//			case "D", "d" -> D;
//			case "E", "e" -> E;
//			default -> F;
//		};
//
//		System.out.print("\n수강일 (년도-학기, 예: 2000-3): ");
//		String takeDate = scanner.nextLine();
//		if(!isValid(takeDate, "takeDate")) { return null; }
//
//		System.out.print("\n구분 (전공(major)/교양(refinement): ");
//		String divide = scanner.nextLine();
//		if(!isValid(divide, "divide")) { return null; }
//
//		Lecture lecture = new Lecture(subject, credit, grade, takeDate, divide);
//		return lecture;
//	}

	private static boolean isValid(String input, String check) {
		switch(check) {
			case "subject":
				if(input == null || input.isBlank() || input.length() > 100) {
					System.out.println("과목명을 1~100글자 범위로 입력하세요.");
					return false;
				}
				break;
			case "credit":
				if(!input.matches("[0-9]{1,3}")) {
					System.out.println("학점을 0~100 범위로 입력하세요.");
					return false;
				}
				break;
			case "grade":
				if(!input.matches("[A-Fa-f]{1}")) {
					System.out.println("성적을 A~F 범위로 입력하세요.");
					return false;
				}
				break;
			case "takeDate":
				if(!input.matches("[0-9]{4}-[0-9]{1}")) {
					System.out.println("수강일을 년도-학기 형식(예: 2000-3)으로 입력하세요.");
					return false;
				}
				break;
			case "divide":
				switch(input) {
					case "전공":
					case "major":
					case "Major":
					case "MAJOR":
					case "교양":
					case "refinement":
					case "Refinement":
					case "REFINEMENT":
						break;
					default:
						System.out.println("구분을 전공/교양 중에서 입력하세요.");
						return false;
				}
				break;
		}
		return true;
	}
}
