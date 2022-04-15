package com.springboot.workers.jbdcexample.util;

import java.util.Date;

public class DateTimeUtilities {

	public static String getCurrentTimestamp() {
		return new Date().toString();
	}

}