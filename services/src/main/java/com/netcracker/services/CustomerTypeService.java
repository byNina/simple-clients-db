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
public interface CustomerTypeService<T> {
	
	List<T> findAll() throws ServiceException;
	
	T get (Serializable id) throws ServiceException;

}
