package com.divya.service;

import java.util.List;

import com.divya.model.UserDetails;

public interface UserService {
	List<UserDetails> getUserDetails();
	addUser(UserDetails User);
	UserDetails findById(String id);
}
