package report0129;

public class MyCalculator<N extends Number> {
//	Object result;

	public N add(N a, N b) {
		Object result = a;
		if(a instanceof Double) { result = a.doubleValue() + b.doubleValue(); }
		else if(a instanceof Float) { result = a.floatValue() + b.floatValue(); }
		else if(a instanceof Long) { result = a.longValue() + b.longValue(); }
		else if(a instanceof Integer) { result = a.intValue() + b.intValue(); }
		else if(a instanceof Short) { result = (short)(a.shortValue() + b.shortValue()); }
		else if(a instanceof Byte) { result = (byte)(a.byteValue() + b.byteValue()); }
		return (N) result;
	}
//	public N add(int a, int b) {
//		result = a + b;
//		return (N) result;
//	}
//	public N add(double a, double b) {
//		result = a + b;
//		return (N) result;
//	}
//	public N sub(N a, N b) {
//		result = (a.doubleValue() - b.doubleValue());
//		return (N) result;
//	}
//	public N sub(int a, int b) {
//		result = a - b;
//		return (N) result;
//	}
//	public N sub(double a, double b) {
//		result = a - b;
//		return (N) result;
//	}
	public N sub(N a, N b) {
		Object result = a;
		if(a instanceof Double) { result = a.doubleValue() - b.doubleValue(); }
		else if(a instanceof Float) { result = a.floatValue() - b.floatValue(); }
		else if(a instanceof Long) { result = a.longValue() - b.longValue(); }
		else if(a instanceof Integer) { result = a.intValue() - b.intValue(); }
		else if(a instanceof Short) { result = (short)(a.shortValue() - b.shortValue()); }
		else if(a instanceof Byte) { result = (byte)(a.byteValue() - b.byteValue()); }
		return (N) result;
	}

	public static void main(String[] args) {
		MyCalculator<Integer> mc = new MyCalculator<>();
		Integer n1 = mc.add(30, 51);
		Integer n2 = mc.sub(63, 23);
		MyCalculator<Double> md = new MyCalculator<>();
		Double d1 = md.add(30.01, 51.62);
		Double d2 = md.sub(63.73, 23.13);

		MyCalculator<Float> mf = new MyCalculator<>();
		Float f1 = mf.add(30.01f, 51.62f);
		Float f2 = mf.sub(63.73f, 23.13f);
		MyCalculator<Long> ml = new MyCalculator<>();
		Long l1 = ml.add(30L, 51L);
		Long l2 = ml.sub(63L, 23L);
		MyCalculator<Short> ms = new MyCalculator<>();
		short ss1 = 30;
		short ss2 = 51;
		Short s1 = ms.add(ss1, ss2);
		short ss3 = 63;
		short ss4 = 23;
		Short s2 = ms.sub(ss3, ss4);
		MyCalculator<Byte> mb = new MyCalculator<>();
		byte bb1 = 30;
		byte bb2 = 51;
		Byte b1 = mb.add(bb1, bb2);
		byte bb3 = 63;
		byte bb4 = 23;
		Byte b2 = mb.sub(bb3, bb4);

		System.out.println(n1);
		System.out.println(n2);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(b1);
		System.out.println(b2);
	}
}
