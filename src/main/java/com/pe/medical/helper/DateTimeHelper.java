package com.pe.medical.helper;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeHelper {
	
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
	
	public static Date getExpirationDate(Long duration) {
		return new Date(System.currentTimeMillis() + duration * 1000);
	}
}
