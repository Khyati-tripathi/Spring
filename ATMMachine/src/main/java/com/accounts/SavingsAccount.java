package com.accounts;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double withdraw(double amount) {
		if (amount > getAccBalance() || amount > 30000) {
			System.out.println("Withdrawl not possible");
			return 0;
		}
		setAccBalance(getAccBalance() - amount);
		return amount;
	}

	@Override
	public double deposit(double amount) {
		if (amount > 1000000) {
			System.out.println("Deposit limit exceeded");
			return 0;
		}
		setAccBalance(getAccBalance() + amount);
		return amount;
	}

}
