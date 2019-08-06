package com.divya.dao;

import java.util.List;

import com.divya.model.UserDetails;

public interface UserDao {
	List<UserDetails> getUserDetails();
	saveOrUpdate(UserDetails User);
	UserDetails findById(String id);

}
