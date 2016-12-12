/**
 * 
 */
package com.netcracker.dao;

import java.util.List;

import com.netcracker.dto.Pagination;
import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.Customer;

/**
 * @author Shevchenko,2016
 *
 */
public interface CustomerDao extends BaseDao<Customer> {

	List<Customer> findByParams(String firstName, String lastName, Pagination pagination)  throws DaoException ;
	
	List<Customer> find() throws DaoException;
	
	Long totalCount(String firstName, String lastName)  throws DaoException ;

}
