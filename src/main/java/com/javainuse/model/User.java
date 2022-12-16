package com.javainuse.model;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Size(min = 5, message = "first name should have at least 5 characters")
	private String firstName;
	
	@NotEmpty
	@Size(min = 5, message = "last name should have at least 5 characters")
	private String lastName;
	
	@NotEmpty
	@Size(min = 8, message = "user name should have at least 8 characters")
	private String username;
	
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	
	
	private String DOB;
	
	
	private String joiningDate;
	
	
	private Integer pincode;
	
	
	private int deleted;
	
	
	
}
