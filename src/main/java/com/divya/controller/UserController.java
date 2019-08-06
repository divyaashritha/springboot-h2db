package com.divya.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.divya.model.Request;
import com.divya.model.Response;
import com.divya.model.UserDetails;
import com.divya.service.UserService;

/**
 * @author divyaashritha
 *
 */
@RestController
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/*
	 * Lists all Users in DB. 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUserDetails() {
        
		List<UserDetails> userDetails = userService.getUserDetails();
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}
	
	/*
	 * Inserts the User data in db using save method in CRUD repository. 
	 * Param: UserDetails JSON object
	 */
	@PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addUser(@RequestBody UserDetails user) {
		
		userService.addUser(User);
		return ResponseEntity.status(200).body("User data has been added.");
	}
	
	/*
	 * Finds unique User based on id
	 * Param: User id.
	 */
	@RequestMapping(value = "/findUser")
	public ResponseEntity<Object> findUser(@RequestParam(value = "id") String id) {
		UserDetails userDetails = userService.findById(id);
		
		if(userDetails==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Data Found.");
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}
	
	
	/*
	 * Processes the POST request and returns JSON object of word and number of occurances. 
	 */
	@PostMapping(path = "/frequencyCount", consumes = "application/json", produces = "application/json")
	public List<Response> freqCount(@RequestBody Request req) {
		List<Response> listResp = new ArrayList<Response>();
		
		String para = req.getPara();
		String[] wordArray = para.split(" ");
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
	    for(String word:wordArray) {
	    	map.put(word, map.getOrDefault(word, 0) + 1);
	    }
	    for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			Response resp = new Response();
			resp.setW(entry.getKey());
			resp.setN(entry.getValue());
			listResp.add(resp);
		}
		return listResp;
	}
}
