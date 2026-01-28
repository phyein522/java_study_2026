package report;

import lombok.Getter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@ToString
public class Lecture {
	//lecture (과목) {과목명, 학점, 성적, 수강일(년도-학기), 구분 divide(전공 major/교양 refinement)}
	private String subject;	//강의명
	private int credit;	//학점
	private double grade;	//성적
	private String takeDate;	//수강일(년도-학기, 예: 2026-5)
	private String divide;	//강의 구분(전공 MAJOR/교양 REFINEMENT)

	public final static double A_PLUS = 4.5;	//A+, a+
	public final static double A = 4.0;	//A0, a0, A, a
	public final static double B_PLUS = 3.5;	//B+, b+
	public final static double B = 3.0;	//B0, b0, B, b
	public final static double C_PLUS = 2.5;	//C+, c+
	public final static double C = 2;	//C0, c0, C, c
	public final static double D_PLUS = 1.5;	//D+, d+
	public final static double D = 1.0;	//D0, d0, D, d
	public final static double F = 0.0;	//default

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
			System.out.print("\n성적 (F~A+): ");
			grade = scanner.nextLine();
		} while(!isValid(grade, "grade"));
		this.setGrade(switch(grade) {
			case "A+", "a+" -> A_PLUS;
			case "A", "a", "A0", "a0" -> A;
			case "B+", "b+" -> B_PLUS;
			case "B", "b", "B0", "b0" -> B;
			case "C+", "c+" -> C_PLUS;
			case "C", "c", "C0", "c0" -> C;
			case "D+", "d+" -> D_PLUS;
			case "D", "d", "D0", "d0" -> D;
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

	private void setSubject(String subject) { this.subject = subject; }
	private void setCredit(int credit) { this.credit = credit; }
	private void setGrade(double grade) { this.grade = grade; }
	private void setTakeDate(String takeDate) { this.takeDate = takeDate; }
	private void setDivide(String divide) { this.divide = divide; }

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
				if(!input.matches("^[A-DFa-df]([0+])?$")) {
					System.out.println("성적을 F~A+ 범위로 입력하세요.");
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
