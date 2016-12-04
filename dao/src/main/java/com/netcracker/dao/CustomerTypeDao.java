/**
 * 
 */
package com.netcracker.dao;

import java.util.List;

import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.CustomerType;

/**
 * @author Shevchenko,2016
 *
 */
public interface CustomerTypeDao extends BaseDao<CustomerType> {

    List<CustomerType> findAll () throws DaoException;

	
}
