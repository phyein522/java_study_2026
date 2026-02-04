package life;

import banking.BankAccount;
import banking.Student;

public class LifeOfStudentWithBank {
	public void doToday() {
		Student str = new Student("문자열", "str1234");
		Student abc = new Student("가나다", "abc5678");

		BankAccount ba1 = new BankAccount("1111-1111-11", "문자열");
		BankAccount ba2 = new BankAccount("2222-2222-22", "가나다");

		StudentHasBankAccount strBank = new StudentHasBankAccount(str, ba1);
		StudentHasBankAccount abcBank = new StudentHasBankAccount(abc, ba2);
	}
}
