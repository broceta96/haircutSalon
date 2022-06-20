package com.haircut.haircutsalon.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public String generateBCryptPassword(String rawPassword) {		
		String cryptPassword = encoder.encode(rawPassword);
		return "Generated BCrypt password = " + cryptPassword;
	}
	
}
