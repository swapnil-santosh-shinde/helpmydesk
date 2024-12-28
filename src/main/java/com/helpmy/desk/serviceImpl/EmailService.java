package com.helpmy.desk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("1 " + toEmail);
        message.setTo(toEmail);
        System.out.println("2 " + toEmail);
        message.setSubject("Your OTP Code");
        System.out.println("3 " + toEmail);
        message.setText("Dear user,\n\nYour OTP code is: " + otp + "\n\nThank you!\nHelpmydesk");
        System.out.println("4 " + toEmail);
        message.setFrom("helpmydesk1@gmail.com");
        System.out.println("5 " + toEmail);
        mailSender.send(message);

        System.out.println("OTP email sent to: " + toEmail);
    }

}
