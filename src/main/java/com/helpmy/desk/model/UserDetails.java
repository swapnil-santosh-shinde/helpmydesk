package com.helpmy.desk.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class UserDetails {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String name;
	@Column(columnDefinition = "TEXT")
	private String lastName;
	@Column(columnDefinition = "TEXT")
	private String email;
	@Column(columnDefinition = "TEXT")
	private String password;
	@Column(columnDefinition = "TEXT")
	private String role;
	@Column(columnDefinition = "TEXT")
	private String comments;
	@Column(columnDefinition = "TEXT")
	private String otp; 
	
}
