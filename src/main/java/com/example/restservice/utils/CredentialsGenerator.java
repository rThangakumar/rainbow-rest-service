package com.example.restservice.utils;

import org.apache.commons.lang3.RandomStringUtils;


public class CredentialsGenerator {
	
	public static String generatePassword() {
		return RandomStringUtils.randomAlphanumeric(9);
	}

}
