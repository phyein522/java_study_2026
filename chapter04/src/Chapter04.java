import java.util.Scanner;

public class Chapter04 {
	public void exercise02() {
		System.out.println("\n2.");

		String grade = "B";
		int score1 = switch(grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100 - 20;
				yield result;
			}
			default -> 60;
		};

		System.out.println(grade + ": " + score1);
	}

	public void exercise03() {
		System.out.println("\n3. for 문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력");

		int sum = 0;
		for(int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println(sum);
	}

	public void exercise04() {
		System.out.println("\n4. while 문과 Math.random() 메소드를 이용해서, 두 개의 주사위를 던졌을 때 나오눈 눈을 (눈1, 눈2) 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행 멈춤 (눈의 합이 5가 되는 경우: (1, 4), (4, 1), (2, 3), (3, 2))");

		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
			System.out.println("(" + num1 + ", " + num2 + ")");
			if(num1 + num2 == 5) {
				break;
			}
		}

		/*
		int num1, num2;
		while((num1 = (int)(Math.random() * 6) + 1) + (num2 = (int)(Math.random() * 6) + 1) != 5) {
			System.out.println("(" + num1 + ", " + num2 + ")");
		}
		*/
	}

	public void exercise05() {
		System.out.println("\n5. 중첩 for 문을 이용하여, 방정식 4x + 5y = 60의 모든 해를 구해서, (x, y) 형태로 출력 (단, x와 y는 10 이하의 자연수)");

		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				if(((4 * x) + (5 * y)) == 60) {
					System.out.println("(" + x + ", " + y +")");
				}
			}
		}
	}

	public void exercise06() {
		System.out.println("\n6. for 문 이용");

		for(int i = 1; i <= 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void exercise07() {
		System.out.println("\n7. while 문과 Scanner의 nextLine() 메소드를 이용해서, 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공");

		Scanner scanner = new Scanner(System.in);

		int select = 0;
		int money = 0;
		while(select != 4) {
			printMessgae();
			//select = Integer.parseInt(scanner.nextLine());
			switch(select = Integer.parseInt(scanner.nextLine())) {
				case 1:
					System.out.print("예금액>  ");
					money += Integer.parseInt(scanner.nextLine());
					break;
				case 2:
					System.out.print("출금액>  ");
					money -= Integer.parseInt(scanner.nextLine());
					break;
				case 3:
					System.out.println("잔고>  " + money);
					break;
				case 4:
					System.out.println("\n프로그램 종료");
			}
		}

		/*
		int select;
		while((select = Integer.parseInt(scanner.nextLine())) != 4) { }
		*/
	}
	public void printMessgae() {
		System.out.println("\n----------------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("----------------------------------------");
		System.out.print("선택>  ");
	}

	public void exercise03while() {
		System.out.println("\n3. while문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합 출력");

		int sum = 0;
		int num = 3;
		while(num <= 100) {
			sum += num;
			num += 3;
		}
		System.out.println(sum);
	}

	public void exercise04for() {
		System.out.println("\n4. for 문과 Math.random() 메소드를 이용해서, 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출려갛고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈춤 (눈의 합이 5가 되는 경우: (1, 4), (4, 1), (2, 3), (3, 2))");

		for(int sum = 0; sum != 5; ) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
			System.out.println("(" + num1 + ", " + num2 + ")");
			sum = num1 + num2;
		}

		/*
		for(int num1 = (int)(Math.random() * 6) + 1, num2 = (int)(Math.random() * 6) + 1; num1 + num2 != 5; num1 = ((int)Math.random() * 6) + 1, num2 = ((int)Math.random() * 6)) {
			System.out.println("(" + num1 + ", " + num2 + ")");
		}
		*/
	}

	public void exercise05while() {
		System.out.println("\n5. 중첩 while문을 이용하여, 방정식 4x + 5y = 60의 모든 해를 구해서, (x, y) 형태로 출력 (단, x와 y는 10 이하의 자연수)");

		int x = 0;
		while(x <= 10) {
			int y = 0;
			while(y <= 10) {
				if(((4 * x) + (5 * y)) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
				y++;
			}
			x++;
		}
	}

	public void exercise06while() {
		System.out.println("\n6. while 문을 이용");

		int i = 1;
		while(i <= 5) {
			int j = 0;
			while(j < i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
