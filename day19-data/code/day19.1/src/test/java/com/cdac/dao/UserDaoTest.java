package com.cdac.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cdac.entities.User;

//data layer testing - DAO , entity , DB
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserDaoTest {
	//depcy - dao layer
	@Autowired
	private UserDao userDao;
	
	@Test //to declare test method - findByEmailAndPassword
	void testFindByEmailAndPassword() {
		//invoke dao's method
		Optional<User> optionalUser = userDao
				.findByEmailAndPassword("neha.patil@gmail.com", "Neha@123");
		
		//1st arg : expected result, 2nd - actual result
		assertEquals(optionalUser.isPresent(),true);
		
	}

}
