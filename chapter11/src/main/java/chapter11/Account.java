package chapter11;

public class Account {
	private long balance;

	public Account() {}

	public long getBalance() {
		return this.balance;
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) throws InsufficientException {
		if(balance < money) {
			throw new InsufficientException("잔고 부족: " + (money - this.getBalance()) + " 모자람");
		}
		this.balance -= money;
	}
}
