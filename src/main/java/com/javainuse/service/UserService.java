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
//		String joiningDate = user.getJoiningDate();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date1 = new Date();
//        Date date2 = new Date();
//        try {
//            date1 = sdf.parse(dob);
//            date2 = sdf.parse(joiningDate);
//        } catch (ParseException e) {
//            
//            e.printStackTrace();
//        }
       
		return userRepository.save(user);
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}


	
}
