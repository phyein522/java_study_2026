package report0129;

public class MyCalculator<N extends Number> {
	Object result;

//	public N add(N a, N b) {
//		result = (a.doubleValue() + b.doubleValue());
//		return (N) result;
//	}
	public N add(int a, int b) {
		result = a + b;
		return (N) result;
	}
	public N add(double a, double b) {
		result = a + b;
		return (N) result;
	}
//	public N sub(N a, N b) {
//		result = (a.doubleValue() - b.doubleValue());
//		return (N) result;
//	}
	public N sub(int a, int b) {
		result = a - b;
		return (N) result;
	}
	public N sub(double a, double b) {
		result = a - b;
		return (N) result;
	}

	public static void main(String[] args) {
		MyCalculator<Integer> mc = new MyCalculator<>();
		Integer n1 = mc.add(30, 51);
		Integer n2 = mc.sub(63, 23);
		MyCalculator<Double> md = new MyCalculator<>();
		Double d1 = md.add(30.01, 51.62);
		Double d2 = md.sub(63.73, 23.13);
	}
}
