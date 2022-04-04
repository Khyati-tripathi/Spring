package com.event;

import java.sql.Timestamp;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {
	double accBalance;
	double amount;

	public WithdrawalEvent(Object source, double accBalance, double amount) {
		super(source);
		this.accBalance = accBalance;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Amount withdrawn: " + this.amount + " Acc Balance =" + accBalance + " Timestamp: "
				+ new Timestamp(System.currentTimeMillis());
	}

}
