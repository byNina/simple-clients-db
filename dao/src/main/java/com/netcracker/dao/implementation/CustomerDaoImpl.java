/**
 * 
 */
package com.netcracker.dao.implementation;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netcracker.dao.CustomerDao;
import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.Customer;

/**
 * @author Shevchenko,2016
 *
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	private static Logger log = Logger.getLogger(CustomerDaoImpl.class);

	private static String GET_CUSTOMERS_BY_PARAMS = "FROM Customer c WHERE c.firstNameMetaphone LIKE :firstName AND c.lastNameMetaphone LIKE :lastName";
	private static String GET_LAST_MODIFIED_CUSTOMERS = "FROM Customer c ORDER BY modifiedWhen DESC";
	private static int MAX_RESULT = 10;

	@Autowired
	protected SessionFactory sessionFactory;

	public CustomerDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findByParams(String metaFirstName, String metaLastName) throws DaoException {
		log.info("Finding customers by parameters");
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Query query = getSession().createQuery(GET_CUSTOMERS_BY_PARAMS);
			query.setParameter("firstName", metaFirstName);
			query.setParameter("lastName", metaLastName);
			customers = query.getResultList();
			log.info("Successfully found customers by parameters");
		} catch (HibernateException e) {
			log.error("Error during find customers by parameters");
			throw new DaoException(e);
		}
		return customers;
	}

	public List<Customer> find() throws DaoException {
		log.info("Finding 10 last modified customers");
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Query query = getSession().createQuery(GET_LAST_MODIFIED_CUSTOMERS);
			query.setMaxResults(MAX_RESULT);
			customers = query.getResultList();
			log.info("Successfully found 10 last modified customers");
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
		return customers;
	}

}
