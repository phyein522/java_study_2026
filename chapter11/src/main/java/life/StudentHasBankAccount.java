package life;

import banking.BankAccount;
import banking.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHasBankAccount {
	private final Student student;
	private final BankAccount bankAccount;

	public void income(int money) {
		//if(money < 0) { throw new ParamMoneyException("잘못된 매개값: " + money); }
		this.getBankAccount().setMoney(this.getBankAccount().getMoney() + money);
		System.out.println("income: " + this.getCurrentMoney());
	}

	public int outcome(int money) {
		//if(money < 0) { throw new ParamMoneyException("잘못된 매개값: " + money); }
		//if(this.getCurrentMoney() < money) { throw new ParamMoneyException("잔액 부족: " + (this.getCurrentMoney() - money)); }
		this.getBankAccount().setMoney(this.getCurrentMoney() - money);
		System.out.println("outcome: " + this.getCurrentMoney() + ", " + money);
		return money;
	}

	//계좌의 현재 금액
	public int getCurrentMoney() {
//		System.out.println("getCurrentMoney: " + this.getBankAccount().getMoney());
		return this.getBankAccount().getMoney();
	}
}
