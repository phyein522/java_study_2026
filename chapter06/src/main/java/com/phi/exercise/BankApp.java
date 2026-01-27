package com.phi.exercise;

import java.util.Scanner;
import java.util.ArrayList;

public class BankApp {
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static boolean on = true;

	private static void print() {
		System.out.println("\n\n--------------------------------------------------");
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("--------------------------------------------------");
		System.out.print("선택>  ");
	}

	private static boolean isOn() {
		return on;
	}
	private static void setOn(boolean on) {
		BankApp.on = on;
	}

	private static void select() {
		Scanner scanner = new Scanner(System.in);
		try {
			switch(scanner.nextLine()) {
				case "1": createAccount(); break;
				case "2": accountList(); break;
				case "3": deposit(); break;
				case "4": withdrawal(); break;
				case "5": endBankApplication(); break;
				default: break;
			}
		} catch(Exception e) { }
	}

	private static void createAccount() {
		System.out.println("\n----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		if(accounts.size() >= 100) {
			System.out.println("더는 계좌생성할 수 없습니다.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		int index = accounts.size();
//		System.out.println(index);
		try {
			accounts.add(new Account());
			System.out.print("계좌번호:  ");
			accounts.get(index).setNumber(scanner.nextLine());
			System.out.print("계좌주:  ");
			accounts.get(index).setName(scanner.nextLine());
			System.out.print("초기입금액:  ");
			accounts.get(index).setBalance(Integer.parseInt(scanner.nextLine()));
			System.out.println("결과: 계좌가 생성되었습니다.");
		} catch (Exception e) {
			System.out.println("결과: 계좌생성 오류");
			accounts.remove(index);
		}
	}
	private static void accountList() {
		System.out.println("\n----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		if(accounts.isEmpty()) {
			System.out.println("계좌목록 없음");
			return;
		}
		try {
			for(Account account : accounts) {
				System.out.println(account.getNumber() + " \t" + account.getName() + " \t" + account.getBalance());
			}
		} catch(Exception e) { }
	}
	private static void deposit() {
		System.out.println("\n----------");
		System.out.println("예금");
		System.out.println("----------");
		Scanner scanner = new Scanner(System.in);
		int index = getIndex();
		if(index == -1) {
//			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
			return;
		}
		System.out.print("예금액:  ");
		try {
			accounts.get(index).setBalance(accounts.get(index).getBalance() + Integer.parseInt(scanner.nextLine()));
		} catch(Exception e) {}
	}
	private static void withdrawal() {
		System.out.println("\n----------");
		System.out.println("출금");
		System.out.println("----------");
		int index = getIndex();
		if(index == -1) {
//			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("출금액:  ");
		try {
			accounts.get(index).setBalance(accounts.get(index).getBalance() - Integer.parseInt(scanner.nextLine()));
		} catch(Exception e) {}
	}
	private static void endBankApplication() {
		System.out.println("\n프로그램 종료\n");
		setOn(false);
	}

	private static int getIndex() {
		if(accounts.isEmpty()) {
			System.out.println("계좌목록 없음");
			return -1;
		}
		Scanner scanner = new Scanner(System.in);
		int index = -1;
		System.out.print("계좌번호:  ");
		try {
			String number = scanner.nextLine();
			for (int i = 0; i < accounts.size(); i++) {
				if (number.equals(accounts.get(i).getNumber())) {
					index = i;
					return index;
//					break;
				}
			}
		} catch(Exception e) {
			return -1;
		}
		if(index == -1) {
			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
			return index;
		}
		return -1;
	}

	public static void start() {
		while(isOn()) {
			print();
			select();
		}
	}
}
