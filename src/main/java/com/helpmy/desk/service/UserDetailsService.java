package com.helpmy.desk.service;

import com.helpmy.desk.model.UserDetails;

public interface UserDetailsService {
	
	 UserDetails saveUser(UserDetails userDetails);
	    boolean validateOtp(String email, String otp);

}
