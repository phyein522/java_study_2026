package chapter11;

public class Chapter11 {
	public void exceptionHandlingExample1() {
		System.out.println("\n\nExceptionHandlingExample1");

		System.out.println("[프로그램 시작]\n");
		ExceptionHandlingExample1.printLength("ThisIsJava");
		try {
			ExceptionHandlingExample1.printLength(null);
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		System.out.println("[프로그램 종료]");
	}
	public void exceptionHandlingExample2() {
		System.out.println("\n\nExceptionHandlingExample2");

		System.out.println("[프로그램 시작]\n");
		ExceptionHandlingExample2.printLength("ThisIsJava");
		ExceptionHandlingExample2.printLength(null);
		System.out.println("[프로그램 종료]");
	}
	public void exceptionHandlingExample3() {
		System.out.println("\n\nExceptionHandlingExample3");

		try {
			Class.forName("java.lang.String");
			System.out.println("java.lang.String 클래스가 존재합니다.");
		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println();
		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 클래스가 존재합니다.");
		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public void exceptionHandlingExample4() {
		System.out.println("\n\nExceptionHandlingExample4");

		String[] array = {"100", "1oo"};

		for(int i = 0; i <= array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "]: " + value);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch(NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
			}
		}
	}
	public void exceptionHandlingExample5() {
		System.out.println("\n\nExceptionHandlingExample5");

		String[] array = {"100", "1oo"};

		for(int i = 0; i <= array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "]: " + value);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch(Exception e) {
				System.out.println("실행에 문제가 있습니다.");
			}
		}
	}
	public void exceptionHandlingExample6() {
		System.out.println("\n\nExceptionHandlingExample6");

		String[] array = {"100", "1oo", null, "200"};

		for(int i = 0; i <= array.length; i++) {
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "]: " + value);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch(NullPointerException | NumberFormatException e) {
				System.out.println("데이터에 문제가 있음: " + e.getMessage());
			}
		}
	}
	public void tryWithResourceExample() {
		System.out.println("\n\nTryWithResourceExample");

		try(MyResource res = new MyResource("A")) {
			String data = res.read1();
			int value = Integer.parseInt(data);
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}

		System.out.println();

		try(MyResource res = new MyResource("A")) {
			String data = res.read2();
			int value = Integer.parseInt(data);
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}

		System.out.println();

		MyResource res1 = new MyResource("A");
		MyResource res2 = new MyResource("B");
		try(res1; res2) {
			String data1 = res1.read1();
			String data2 = res2.read1();
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
	}
	public void throwsExample1() {
		System.out.println("\n\nThrowsExample1");

		try {
			ThrowsExample1.findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("예외 처리: " + e.toString());
		}
	}
	public void throwsExample2() {
		System.out.println("\n\nThrowsExample2");

		try {
			ThrowsExample2.findClass();
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.toString());
		}
	}
	public void accountExample() {
		System.out.println("\n\nAccountExample");

		Account account = new Account();
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());

		try {
			account.withdraw(30000);
		} catch(InsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
