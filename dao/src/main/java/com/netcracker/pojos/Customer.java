/**
 * 
 */
package com.netcracker.pojos;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Shevchenko,2016
 *
 */
@javax.persistence.Entity
@Table(name = "customers")
public class Customer extends Entity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customer_id")
	@SequenceGenerator(name = "my_seq", sequenceName = "seq_01")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "first_name_metaphone")
	private String firstNameMetaphone;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "last_name_metaphone")
	private String lastNameMetaphone;

	@Column(name = "modified_when")
	private Date modifiedWhen;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CustomerType customerType;

	public Customer() {

	}

	

	public Customer(String title, String firstName, String firstNameMetaphone, String lastName,
			String lastNameMetaphone, Date modifiedWhen, CustomerType customerType) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.firstNameMetaphone = firstNameMetaphone;
		this.lastName = lastName;
		this.lastNameMetaphone = lastNameMetaphone;
		this.modifiedWhen = modifiedWhen;
		this.customerType = customerType;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstNameMetaphone() {
		return firstNameMetaphone;
	}

	public void setFirstNameMetaphone(String firstNameMetaphone) {
		this.firstNameMetaphone = firstNameMetaphone;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastNameMetaphone() {
		return lastNameMetaphone;
	}

	public void setLastNameMetaphone(String lastNameMetaphone) {
		this.lastNameMetaphone = lastNameMetaphone;
	}

	public Date getModifiedWhen() {
		return modifiedWhen;
	}

	public void setModifiedWhen(Date modifiedWhen) {
		this.modifiedWhen = modifiedWhen;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((firstNameMetaphone == null) ? 0 : firstNameMetaphone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lastNameMetaphone == null) ? 0 : lastNameMetaphone.hashCode());
		result = prime * result + ((modifiedWhen == null) ? 0 : modifiedWhen.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerType == null) {
			if (other.customerType != null)
				return false;
		} else if (!customerType.equals(other.customerType))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (firstNameMetaphone == null) {
			if (other.firstNameMetaphone != null)
				return false;
		} else if (!firstNameMetaphone.equals(other.firstNameMetaphone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastNameMetaphone == null) {
			if (other.lastNameMetaphone != null)
				return false;
		} else if (!lastNameMetaphone.equals(other.lastNameMetaphone))
			return false;
		if (modifiedWhen == null) {
			if (other.modifiedWhen != null)
				return false;
		} else if (!modifiedWhen.equals(other.modifiedWhen))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", modifiedWhen=" + modifiedWhen + ", customerType=" + customerType + "]";
	}

}
