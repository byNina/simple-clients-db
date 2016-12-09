/**
 * 
 */
package com.netcracker.services;

import java.io.Serializable;
import java.util.List;

import com.netcracker.exceptions.ServiceException;

/**
 * @author Shevchenko,2016
 *
 */
public interface CustomerService<T> {

	/**
	 * Save new customer in database or update the last-one if he exists
	 * 
	 * @param t
	 */
	void saveOrUpdate(T t) throws ServiceException;

	/**
	 * Delete existing customer
	 * 
	 * @param t
	 */
	void delete(T t) throws ServiceException;

	/**
	 * Find a list of customers by first name and last name using metaphone
	 * algorithm
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	List<T> find(String firstName, String lastName) throws ServiceException;

	/**
	 * Find a list of customers without any params
	 * 
	 * @return
	 */
	List<T> find() throws ServiceException;

	/**
	 * Create a new customer in Database according to params
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param type
	 * @throws ServiceException
	 */

	void create(String title, String firstName, String lastName, int type) throws ServiceException;

	/**
	 * Get a customer by his id
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	T get(Serializable id) throws ServiceException;
	
	/**
	 * Delete customer by his id
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	
	void delete(Serializable id) throws ServiceException;
	
	
}
