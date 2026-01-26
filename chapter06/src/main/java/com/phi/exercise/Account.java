package com.phi.exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	//exercise19
	private int balance;
	private final static int MIN_BALANCE = 0;
	private final static int MAX_BALANCE = 1000000;

	private String number;
	private String name;

	public void setBalance(int balance) {
		this.balance = balance > MIN_BALANCE ? (balance < MAX_BALANCE ? balance : this.balance) : this.balance;
	}
}
