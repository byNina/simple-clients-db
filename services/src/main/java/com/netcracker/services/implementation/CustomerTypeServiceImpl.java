/**
 * 
 */
package com.netcracker.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.dao.CustomerTypeDao;
import com.netcracker.exceptions.DaoException;
import com.netcracker.exceptions.ServiceException;
import com.netcracker.pojos.CustomerType;
import com.netcracker.services.CustomerTypeService;

/**
 * @author Shevchenko,2016
 *
 */
@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService<CustomerType> {
	private static Logger log = Logger.getLogger(CustomerTypeServiceImpl.class);

	@Autowired
	private CustomerTypeDao customerTypeDao;

	public List<CustomerType> findAll() throws ServiceException {
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		try {
			customerTypes = customerTypeDao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return customerTypes;
	}

}
