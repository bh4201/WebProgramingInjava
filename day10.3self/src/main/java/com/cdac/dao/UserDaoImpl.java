package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.User;
import com.cdac.entities.UserRole;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getSelectedUsers(LocalDate start, LocalDate end, UserRole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userSignIn(String next, String next2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSelectedUsersFirstNames(UserRole valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getSelectedUsersDetails(UserRole valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserDetails(LocalDate date, double discount) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
