/**
 * 
 */
package com.netcracker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

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
		List<CustomerType> customerTypes = null;
		try {
			customerTypes = customerTypeService.findAll();
			model.addAttribute("customerTypes", customerTypes);
		} catch (ServiceException e) {
			model.addAttribute("errorMessage", Messanger.GET_TYPES_ERROR);
		}
		return "createCustomer";
	}

	@RequestMapping(value = "createNewCustomer", method = RequestMethod.GET)
	public String createNewCustomer(ModelMap model, HttpServletRequest request) {
		String page = "createCustomer";
		String title = request.getParameter("title").trim();
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		int type = Integer.parseInt(request.getParameter("type"));
		if (isValid(title, firstName, lastName, type)) {
			try {
				customerService.create(title, firstName, lastName, type);
				page = "main";
				model.addAttribute("successMessage",
						Messanger.SUCCESSFUL_CREATED_CUSTOMER + title + " " + firstName + " " + lastName);
			} catch (ServiceException e) {
				model.addAttribute("errorMessage", Messanger.CREATING_CUSTOMER_ERROR);
			}
		} else {
			model.addAttribute("errorMessage", Messanger.IS_NOT_VALID);
		}
		return page;
	}

	@RequestMapping(value = "findCustomer", method = RequestMethod.GET)
	public String findCustomer(ModelMap model, HttpServletRequest request) {
		String page = "main";
		List<Customer> customers;
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		try {
			if (formIsNotEmpty(firstName, lastName)) {
				customers = customerService.find(firstName, lastName);
			} else {
				customers = customerService.find();
			}
			if (customers != null && !customers.isEmpty()) {
				model.addAttribute("customers", customers);
				page = "customersList";
			} else {
				model.addAttribute("error", Messanger.CUSTOMERS_NOT_FOUND);
			}
		} catch (ServiceException e) {
			model.addAttribute("error", Messanger.FINDING_CUSTOMERS_ERROR);
		}
		return page;
	}

	@RequestMapping(value = "customerInfo", method = RequestMethod.GET)
	public String customerInfo(ModelMap model, HttpServletRequest request) {
		String page = "customerInfo";
		Customer customer = null;
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		try {
			customer = (Customer) customerService.get(customerId);
			model.addAttribute("customer", customer);
		} catch (ServiceException e) {
			model.addAttribute("errorMessage", Messanger.GETTING_CUSTOMER_ERROR);
		}
		return page;
	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(ModelMap model, HttpServletRequest request) {
		String page = "customerInfo";
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		try {
			customerService.delete(customerId);
			page = "main";
		} catch (ServiceException e) {
			model.addAttribute("errorMessage", Messanger.DELETING_CUSTOMER_ERROR);
		}
		return page;
	}

	@RequestMapping(value = "toModifyCustomer", method = RequestMethod.GET)
	public String toModifyCustomer(ModelMap model, HttpServletRequest request) {
		String page = "modifyCustomer";
		List<CustomerType> customerTypes = null;
		Customer customer = null;
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		System.out.println("CustomerId" + customerId);
		try {
			customerTypes = customerTypeService.findAll();
			customer = (Customer) customerService.get(customerId);
			if (customerTypes != null && !customerTypes.isEmpty() && customer != null) {
				model.addAttribute("customerTypes", customerTypes);
				model.addAttribute("customer", customer);
			}
		} catch (ServiceException e) {
			model.addAttribute("errorMessage", Messanger.GET_TYPES_ERROR);
		}
		return page;
	}

	@RequestMapping(value = "modifyCustomer", method = RequestMethod.GET)
	public String modifyCustomer(ModelMap model, HttpServletRequest request) {
		String page = "toModifyCustomer";
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		try {
			Customer customer = (Customer) customerService.get(customerId);
			if (customer != null && modifyCustomer(customer, request)) {
				customerService.saveOrUpdate(customer);
				model.addAttribute("customer", customer);
				page = "customerInfo";
			} else {
				model.addAttribute("errorMessage", Messanger.MODIFY_CUSTOMER_ERROR);
			}
		} catch (ServiceException e) {
			model.addAttribute("errorMessage", Messanger.MODIFY_CUSTOMER_ERROR);
		}
		return page;
	}

	private boolean isValid(String title, String firstName, String lastName, int type) {
		if (checkTitle(title) && checkFirstName(firstName) && checkLastName(lastName) && checkType(type)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkTitle(String title) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]{1,3}$");
		Matcher matcher = pattern.matcher(title);
		return matcher.matches();
	}

	private boolean checkFirstName(String firstName) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]{3,50}$");
		Matcher matcher = pattern.matcher(firstName);
		return matcher.matches();
	}

	private boolean checkLastName(String lastName) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]{4,50}$");
		Matcher matcher = pattern.matcher(lastName);
		return matcher.matches();
	}

	private boolean checkType(int type) {
		// TODO compare with id from database ( redundant)
		return true;
	}

	private boolean formIsNotEmpty(String firstName, String lastName) {
		if (firstName != "" || lastName != "") {
			return true;
		} else {
			return false;
		}
	}

	private boolean modifyCustomer(Customer customer, HttpServletRequest request) throws ServiceException {
		boolean isModified = false;
		String title = request.getParameter("title");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		if (isValid(title, firstName, lastName, typeId)) {
			CustomerType type = null;
			try {
				type = (CustomerType) customerTypeService.get(typeId);
			} catch (ServiceException e) {
				throw e;
			}
			if (type != null) {
				customer.setTitle(request.getParameter("title"));
				customer.setFirstName(request.getParameter("firstName"));
				customer.setLastName(request.getParameter("lastName"));
				customer.setCustomerType(type);
				customer.setModifiedWhen(new Date());
				isModified = true;
			}
		}
		return isModified;
	}

}
