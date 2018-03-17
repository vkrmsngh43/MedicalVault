package com.pe.medical.helper;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenericUtil {
	
	//generate a six digit random integer.
	public int generateAccessCode() {
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}

}
