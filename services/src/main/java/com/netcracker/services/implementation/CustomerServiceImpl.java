/**
 * 
 */
package com.netcracker.services.implementation;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.language.Metaphone;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.dao.CustomerDao;
import com.netcracker.dao.CustomerTypeDao;
import com.netcracker.exceptions.DaoException;
import com.netcracker.exceptions.ServiceException;
import com.netcracker.pojos.Customer;
import com.netcracker.pojos.CustomerType;
import com.netcracker.services.CustomerService;

/**
 * @author Shevchenko,2016
 *
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService<Customer> {
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerTypeDao customerTypeDao;

	private static Metaphone metaphone = new Metaphone();

	public void save(Customer customer) throws ServiceException {
		try {
			customerDao.saveOrUpdate(customer);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public void delete(Customer customer) throws ServiceException {
		try {
			customerDao.delete(customer);
			;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public List<Customer> find(String firstName, String lastName) throws ServiceException {
		List<Customer> customers = null;
		try {
			customers = customerDao.findByParams(firstName, lastName);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return customers;
	}

	public List<Customer> find() {
		// TODO Find 10 last modified customers
		return null;
	}

	public void create(String title, String firstName, String lastName, int type) throws ServiceException {
		CustomerType customerType;
		String metaFirstName = metaphone.encode(firstName);
		String metaLastName = metaphone.encode(lastName);
		Date currentTime = new Date();
		try {
			customerType = customerTypeDao.get(type);
			Customer newCustomer = new Customer(title, firstName, metaFirstName, lastName, metaLastName, currentTime,
					customerType);
			customerDao.save(newCustomer);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
