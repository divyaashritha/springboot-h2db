package com.divya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.dao.UserDao;
import com.divya.model.UserDetails;
import com.divya.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * Lists all the User using the CRUD repository getUserDetails
	 */
	public List<UserDetails> getUserDetails() {
		return userDao.getUserDetails();
	}
	
	/*
	 * Adds the User using the CRUD repository addUser
	 * Param: UserDetails
	 */
	public void addUser(UserDetails User){
		return userDao.saveOrUpdate(User);
	}
	
	/*
	 * Finds the User using the CRUD repository findById
	 * Param: id
	 */
	public UserDetails findById(String id) {
		return userDao.findById(new Long(id));
	}
}
