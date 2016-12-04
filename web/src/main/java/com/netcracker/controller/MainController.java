/**
 * 
 */
package com.netcracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.pojos.Customer;
import com.netcracker.services.CustomerService;

/**
 * @author Shevchenko,2016
 *
 */
@Controller
public class MainController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping (value = "main", method = RequestMethod.GET)
	public String showMainPage(Model model){
		return "main";
	}
	
	@RequestMapping (value = "test", method = RequestMethod.GET)
	public String test (Model model){
		return "test";
	}
	
	
}
