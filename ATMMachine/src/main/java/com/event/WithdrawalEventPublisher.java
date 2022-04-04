package com.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		// TODO Auto-generated method stub

	}

	public void publish(double accBalance, double amount) {
		WithdrawalEvent event = new WithdrawalEvent(publisher, accBalance, amount);
		this.publisher.publishEvent(event);
	}

}
