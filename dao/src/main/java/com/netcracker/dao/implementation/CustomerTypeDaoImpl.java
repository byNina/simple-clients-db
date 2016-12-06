/**
 * 
 */
package com.netcracker.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netcracker.dao.CustomerTypeDao;
import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.CustomerType;

/**
 * @author Shevchenko,2016
 *
 */
@Repository
public class CustomerTypeDaoImpl extends BaseDaoImpl<CustomerType> implements CustomerTypeDao {
	private static Logger log = Logger.getLogger(CustomerTypeDaoImpl.class);
	private static final String FIND_ALL = "FROM CustomerType";

	public CustomerTypeDaoImpl() {
	}
	
	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<CustomerType> findAll() throws DaoException {
		log.info("Finding all");
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		try {
			customerTypes = getSession().createQuery(FIND_ALL).getResultList();
			log.info("Successfully found all customer types");
		} catch (HibernateException e) {
			log.error("Error during find all customer types");
			throw new DaoException(e);
		}
		return customerTypes;
	}

}
