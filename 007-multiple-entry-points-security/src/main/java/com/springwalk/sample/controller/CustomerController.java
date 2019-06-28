/*
 * Copyright (c) 2015 SK C&C Co., Ltd. All rights reserved.
 *
 * This software is the confidential and proprietary information of SK C&C.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance wih the terms of the license agreement you entered into
 * with SK C&C.
 */
package com.springwalk.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

import com.springwalk.sample.model.Customer;

 
@Controller
public class CustomerController {
	
	
	@RequestMapping(path="/user", method = RequestMethod.GET)
	public ResponseEntity  listUser(){
		return new ResponseEntity(getCustomers(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/guest/1", method = RequestMethod.GET)
	public ResponseEntity  guest(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user", "oscorp");
		return new ResponseEntity(map, HttpStatus.OK) ;
	}
	

	 

	@RequestMapping(path="/user", method = RequestMethod.POST)
	public ResponseEntity  listUser(@RequestBody Customer user){
		return new ResponseEntity("18", HttpStatus.OK);
	}
	
	
	public List<Customer> getCustomers(){
		List<Customer> customers=new ArrayList<>();
		
		Customer c1= new Customer("C1","Primero");
		Customer c2= new Customer("C2","Segundo");
		Customer c3= new Customer("C3","Tercero");
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		return customers;
	}
}
