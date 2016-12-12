/**
 * 
 */
package com.netcracker.dao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.dao.CustomerDao;
import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.Customer;
import com.netcracker.pojos.CustomerType;

/**
 * @author Shevchenko,2016
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dao-test-config.xml")
@Transactional
public class BaseDaoImplTest {
	private static final int WRONG_CUSTOMER_ID = 100;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerDao customerDao;

	private Session session;
	private Customer customer1;
	private Customer customer2;
	private Customer customer3;
	private Customer customer4;

	@Test
	public void deleteTest() throws DaoException {
		customer1 = TestUtils.createCustomer("Marian");
		session = sessionFactory.getCurrentSession();
		session.save(customer1);
		flushAndClearSession();

		customer1 = (Customer) session.get(Customer.class, customer1.getId());
		customerDao.delete(customer1);
		flushAndClearSession();

		Customer actualCustomer = (Customer) session.get(Customer.class, customer1.getId());
		assertNull(actualCustomer);
	}

	@Test
	public void saveOrUpdateTest() throws DaoException {
		customer2 = TestUtils.createCustomer("Tina");
		session = sessionFactory.getCurrentSession();
		session.save(customer2);
		flushAndClearSession();

		customer2.setFirstName("Volha");
		customerDao.saveOrUpdate(customer2);

		flushAndClearSession();
		Customer actualCustomer = (Customer) session.get(Customer.class, customer2.getId());

		assertEquals(customer2, actualCustomer);
	}

	@Test
	public void getTest() throws DaoException {
		customer3 = TestUtils.createCustomer("Tammy");
		session = sessionFactory.getCurrentSession();
		session.save(customer3);
		flushAndClearSession();
		Customer actualCustomer = customerDao.get(customer3.getId());
		assertEquals(customer3, actualCustomer);

		Customer notExistingCustomer = customerDao.get(WRONG_CUSTOMER_ID);
		assertNull(notExistingCustomer);
	}

	@Test
	public void saveTest() throws DaoException {
		customer4 = TestUtils.createCustomer("Rolando");
		session = sessionFactory.getCurrentSession();
		session.save(customer4);
		flushAndClearSession();

		Customer actualCustomer = (Customer) session.get(Customer.class, customer4.getId());
		assertNotNull(actualCustomer);
	}

	private void flushAndClearSession() {
		session.flush();
		session.clear();
	    }
	
}
