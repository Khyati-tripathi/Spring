package com.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accounts.SalaryAccount;
import com.accounts.SavingsAccount;
import com.event.WithdrawalEventPublisher;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WithdrawalEventPublisher pub = (WithdrawalEventPublisher) context.getBean("withdrawalEventPublisher");
		SalaryAccount salaryAccount = (SalaryAccount) context.getBean("salaryAccount");
		double amt = salaryAccount.withdraw(100000);
		pub.publish(salaryAccount.getAccBalance(), amt);
		SavingsAccount save = (SavingsAccount) context.getBean("savingsAccount");
		double amtsave = save.withdraw(1000);
		pub.publish(save.getAccBalance(), amtsave);

	}

}
