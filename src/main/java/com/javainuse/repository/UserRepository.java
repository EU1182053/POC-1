package com.javainuse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javainuse.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query("select u from user where u.firstname=?1 or u.lastName=?2 or u.pincode=?3;")
//	List<User> getUsersByParams(String firstName, String lastname, int pincode);
	
	List<User> findByFirstNameOrLastNameOrPincode(String firstName, String lastName, int pincode);
}
