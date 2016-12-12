/**
 * 
 */
package com.netcracker.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.dao.CustomerDao;
import com.netcracker.dto.Pagination;
import com.netcracker.exceptions.DaoException;
import com.netcracker.pojos.Customer;

/**
 * @author Shevchenko,2016
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dao-test-config.xml")
@Transactional
public class CustomerDaoImplTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerDao customerDao;

	private Session session;
	private Customer customer1;
	private Customer customer2;

	@Test
	public void findByParamsTest() throws DaoException {
		customer1 = TestUtils.createCustomer("Vanessa");
		session = sessionFactory.getCurrentSession();
		session.save(customer1);
		flushAndClearSession();
		Pagination pagination = new Pagination(10, 1);

		List<Customer> existingCustomer1 = customerDao.findByParams(customer1.getFirstNameMetaphone(), "%", pagination);
		assertFalse(existingCustomer1.isEmpty());

		List<Customer> existingCustomer2 = customerDao.findByParams(customer1.getFirstNameMetaphone(), customer1.getLastNameMetaphone(), pagination);
		assertFalse(existingCustomer2.isEmpty());
	}

	@Test
	public void find() throws DaoException {
		List<Customer> customers = new ArrayList<Customer>();
		session = sessionFactory.getCurrentSession();
		for (int i = 0; i < 12; i++) {
			customer2 = TestUtils.createCustomer("Vanessa");
			session.save(customer2);
		}
		flushAndClearSession();

		customers = customerDao.find();
		int listLenght = customers.size();
		assertEquals(10, listLenght);
	}

	private void flushAndClearSession() {
		session.flush();
		session.clear();
	}

}
