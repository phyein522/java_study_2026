package chapter11;

public class ThrowsExample1 {
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
