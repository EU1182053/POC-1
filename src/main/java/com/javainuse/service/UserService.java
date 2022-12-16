package com.javainuse.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.model.User;
import com.javainuse.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
//		String dob = user.getDOB();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
//		java.util.Date dateStr = null;
//		try {
//			dateStr = formatter.parse(dob);
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//		java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
//		
//		String joiningDate = user.getDOB();
//		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); // your template here
//		java.util.Date dateStr1 = null;
//		try {
//			dateStr1 = formatter1.parse(joiningDate);
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//		java.sql.Date joiningDate1 = new java.sql.Date(dateStr1.getTime());
//		
//		return userRepository.save(user);
		
		user.setDOB("2022-12-16 10:50:54");
		user.setJoiningDate("2022-12-16 10:59:54");
		return userRepository.save(user);
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}


	
}
