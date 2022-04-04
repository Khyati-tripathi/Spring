package com.accounts;

public class SalaryAccount extends BankAccount {
	public SalaryAccount(int accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}

	@Override
	public double withdraw(double amount) {
		if (amount > getAccBalance() || amount > 100000) {
			System.out.println("Withdrawl not possible");
			return 0;

		}
		this.setAccBalance(getAccBalance() - amount);
		return amount;

	}

	@Override
	public double deposit(double amount) {
		this.setAccBalance(getAccBalance() + amount);
		return amount;

	}

}
