package com.phi.package1;

/*
public class B {
	A a;
}
*/
/*
public class B {
	A A1 = new A(true);
	A a2 = new A(1);
//	A a3 = new A("문자열");
}
*/

public class B {
	public void method() {
		A a = new A();

		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1;

		a.method1();
		a.method2();
//		a.method3();
	}
}