/**
 * 
 */
package com.netcracker.dao;

import java.io.Serializable;
import java.util.List;

import com.netcracker.exceptions.DaoException;

/**
 * @author Shevchenko,2016
 *
 */
public interface BaseDao<T> {
	
	void delete(T t) throws DaoException;
	
	void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    Serializable save(T entity) throws DaoException;
    

}
