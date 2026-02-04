package chapter11;

public class MyResource implements AutoCloseable {
	private String name;

	public String getName() { return this.name; }

	public MyResource(String name) {
		this.name = name;
		System.out.println("[myResource(" + name + ") 열기]");
	}

	public String read1() {
		System.out.println("[MyResource(" + this.getName() + ") 읽기]");
		return "100";
	}

	public String read2() {
		System.out.println("[MyResource(" + this.getName() + ") 읽기]");
		return "abc";
	}

	@Override
	public void close() throws Exception {
		System.out.println("[MyResource(" + this.getName() + ") 닫기]");
	}
}
