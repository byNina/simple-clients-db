/**
 * 
 */
package com.netcracker.services;

import java.util.List;

import com.netcracker.exceptions.ServiceException;

/**
 * @author Shevchenko,2016
 *
 */
public interface CustomerTypeService<T> {
	
	List<T> findAll() throws ServiceException;

}
