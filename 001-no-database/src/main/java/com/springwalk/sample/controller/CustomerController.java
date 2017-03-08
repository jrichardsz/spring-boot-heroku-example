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
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springwalk.sample.model.Customer;

/**
 * 
 * @author sini
 * @date May 18, 2015
 */
@RestController
public class CustomerController {
	
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Customer> getCustomers(){
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer("John","McClane");
		customers.add(customer);
		customer = new Customer("John","Wick");
		customers.add(customer);
		customer = new Customer("John","Rambo");
		customers.add(customer);
		
		return customers;
	}
}
