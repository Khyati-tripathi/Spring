package com.event;

import org.springframework.context.ApplicationListener;

public class EventHandler implements ApplicationListener<WithdrawalEvent> {

	@Override
	public void onApplicationEvent(WithdrawalEvent event) {
		System.out.println(event);

	}

}
