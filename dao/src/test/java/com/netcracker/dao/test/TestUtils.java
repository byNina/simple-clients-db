package com.netcracker.dao.test;

import java.util.Date;

import org.apache.commons.codec.language.Metaphone;
import org.hibernate.Session;

import com.netcracker.pojos.Customer;

public class TestUtils {
	
	private static Metaphone metaphone = new Metaphone();

	public static Customer createCustomer(String name) {
		Customer customer = new Customer();
		customer.setTitle("Mrs");
		customer.setFirstName(name);
		customer.setFirstNameMetaphone(metaphone.encode(customer.getFirstName()));
		customer.setLastName("Ignatova");
		customer.setLastNameMetaphone(metaphone.encode(customer.getLastName()));
		customer.setModifiedWhen(new Date());
		return customer;
	}

}
