package com.helpmy.desk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helpmy.desk.model.UserDetails;
import com.helpmy.desk.service.UserDetailsService;

@RestController
@RequestMapping("/api/users")
public class UserDetailsController {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDetails userDetails) {
        UserDetails savedUser = userDetailsService.saveUser(userDetails);
        return ResponseEntity.ok("User created successfully. OTP sent to email: " + savedUser.getEmail());
    }
	
	
	// API to validate OTP
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/validate-otp")
    public ResponseEntity<String> validateOtp(@RequestParam("email") String email, @RequestParam("otp") String otp) {
        boolean isValid = userDetailsService.validateOtp(email, otp);
        if (isValid) {
            return ResponseEntity.ok("OTP is valid. Email verified successfully.");
        } else {
            return ResponseEntity.status(400).body("Invalid OTP. Please try again.");
        }
    }


}
