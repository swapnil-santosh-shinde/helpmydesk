package com.helpmy.desk.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpmy.desk.model.UserDetails;
import com.helpmy.desk.repo.UserRepository;
import com.helpmy.desk.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userDetailsRepository;
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private SimpleEmailService email;


	@Override
	public UserDetails saveUser(UserDetails userDetails) {
		Optional<UserDetails> existingUser = userDetailsRepository.findByEmail(userDetails.getEmail());
	    if (existingUser.isPresent()) {
	        throw new RuntimeException("Email address already used");
	    }
	    // Generate a 4-digit OTP
	    String otp = String.valueOf(new Random().nextInt(9000) + 1000);
	    userDetails.setOtp(otp);
	    // Save user details in the database
	    UserDetails savedUser = userDetailsRepository.save(userDetails);
	    // Send OTP via email (simulate email sending)
	    System.out.println("OTP sent to email: " + userDetails.getEmail() + " - OTP: " + otp);
	    //emailService.sendOtpEmail(userDetails.getEmail(), otp);
	   // String body= "Dear user,\n\nYour OTP code is: " + otp + "\n\nThank you!\nHelpmydesk";
//email.sendEmail(userDetails.getEmail(), "Your OTP Code", body);

	    return savedUser;
	}
	

	@Override
	public boolean validateOtp(String email, String otp) {
		   Optional<UserDetails> userDetailsOptional = userDetailsRepository.findByEmail(email);
	        if (userDetailsOptional.isPresent()) {
	            UserDetails userDetails = userDetailsOptional.get();
	            return otp.equals(userDetails.getOtp());
	        }
	        return false;
	}

}
