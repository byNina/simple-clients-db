/**
 * 
 */
package com.netcracker.dao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.pojos.Customer;

/**
 * @author Shevchenko,2016
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dao-test-config.xml")
@Transactional
public class BaseDaoImplTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Customer customer1;
	

	@Test
	public void deleteTest() {

		
		
		;
	}

	
	private void createCustomer(){
		Customer customer = new Customer();
		customer.setTitle("Mrs");
		customer.setFirstName("Serafima");
		customer.setFirstNameMetaphone("SS");
		customer.setLastName("Ignatova");
		customer.setLastNameMetaphone("FTHC");
		customer.setModifiedWhen(new Date());
		
		customer.setCustomerType(customerType);
	}
}
