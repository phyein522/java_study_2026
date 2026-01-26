package com.phi.exercise;

import java.util.Scanner;

public class BankApplication {
	//exercise20
	private static Account[] accounts = new Account[100];
	private static int counter = 0;
	private static boolean on = true;

	private static void print() {
		System.out.println("\n\n--------------------------------------------------");
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("--------------------------------------------------");
		System.out.print("선택>  ");
	}

	private static void select() {
		Scanner scanner = new Scanner(System.in);
		String select = scanner.nextLine();
		switch(select) {
			case "1": createAccount(); break;
			case "2": accountList(); break;
			case "3": deposit(); break;
			case "4": withdrawal(); break;
			case "5": endBankApplication(); break;
			default: break;
		}
	}

	private static void createAccount() {
		System.out.println("\n----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		if(counter >= accounts.length) {
			System.out.println("더는 계좌생성할 수 없습니다.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		try {
			accounts[counter] = new Account();
			System.out.print("계좌번호:  ");
			accounts[counter].setNumber(scanner.nextLine());
			System.out.print("계좌주:  ");
			accounts[counter].setName(scanner.nextLine());
			System.out.print("초기입금액:  ");
			accounts[counter].setBalance(Integer.parseInt(scanner.nextLine()));
			System.out.println("결과: 계좌가 생성되었습니다.");
			counter++;
		} catch (Exception e) {
			System.out.println("결과: 계좌생성 오류");
			accounts[counter] = null;
		}
	}
	private static void accountList() {
		System.out.println("\n----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		if(accounts[0] == null) {
			System.out.println("계좌목록 없음");
			return;
		}
		try {
			for(Account account : accounts) {
				if(account == null) {
					return;
				}
				System.out.println(account.getNumber() + " \t" + account.getName() + " \t" + account.getBalance());
			}
		} catch(Exception e) { }
	}
	private static void deposit() {
		System.out.println("\n----------");
		System.out.println("예금");
		System.out.println("----------");
		if(accounts[0] == null) {
			System.out.println("계좌목록 없음");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("계좌번호:  ");
		String number = scanner.nextLine();
		int index = 0;
		try {
			for(int i = 0; i < accounts.length; i++) {
				if(number.equals(accounts[i].getNumber())) {
					index = i;
					break;
				}
			}
		} catch(Exception e) {
			return;
		}
		System.out.print("예금액:  ");
		accounts[index].setBalance(accounts[index].getBalance() + Integer.parseInt(scanner.nextLine()));
	}
	private static void withdrawal() {
		System.out.println("\n----------");
		System.out.println("출금");
		System.out.println("----------");
		if(accounts[0] == null) {
			System.out.println("계좌목록 없음");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("계좌번호:  ");
		String number = scanner.nextLine();
		int index = 0;
		try {
			for(int i = 0; i < accounts.length; i++) {
				if(number.equals(accounts[i].getNumber())) {
					index = i;
					break;
				}
			}
		} catch(Exception e) {
			return;
		}
		System.out.print("출금액:  ");
		accounts[index].setBalance(accounts[index].getBalance() - Integer.parseInt(scanner.nextLine()));
	}
	private static void endBankApplication() {
		System.out.println("\n프로그램 종료\n");
		setOn(false);
	}

	public static boolean isOn() {
		return on;
	}
	public static void setOn(boolean on) {
		BankApplication.on = on;
	}

	public static void start() {
		while(isOn()) {
			print();
			select();
		}
	}

//	public static void main(String[] args) {
//		while(isOn()) {
//			print();
//			select();
//		}
//	}
}
