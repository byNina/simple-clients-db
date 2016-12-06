/**
 * 
 */
package com.netcracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.exceptions.ServiceException;
import com.netcracker.messanger.Messanger;
import com.netcracker.pojos.Customer;
import com.netcracker.pojos.CustomerType;
import com.netcracker.services.CustomerService;
import com.netcracker.services.CustomerTypeService;

/**
 * @author Shevchenko,2016
 *
 */
@Controller
public class MainController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private CustomerService customerService;

	@SuppressWarnings("rawtypes")
	@Autowired
	private CustomerTypeService customerTypeService;

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String showMainPage(Model model) {
		return "main";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(Model model) {
		return "test";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "toCreateNewCustomer", method = RequestMethod.GET)
	public String toCreateNewCustomer(ModelMap model) {
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		try {
			customerTypes = customerTypeService.findAll();
			model.addAttribute("customerTypes", customerTypes);
		} catch (ServiceException e) {
			model.addAttribute("error", Messanger.GET_TYPES_ERROR);
		}

		return "createCustomer";
	}

}
