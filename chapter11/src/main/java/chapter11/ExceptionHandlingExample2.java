package chapter11;

public class ExceptionHandlingExample2 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자 수: " + result);
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
//			e.printStackTrace();
		} finally {
			System.out.println("[마무리 실행]\n");
		}
	}
}
