/**
 * 
 */
package com.netcracker.pojos;

import javax.persistence.*;


/**
 * @author Shevchenko,2016
 *
 */
@javax.persistence.Entity
@Table (name="CUSTOMER_TYPES")
public class CustomerType extends Entity{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="my_seq", sequenceName="seq_01")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
	private Integer id;

	@Column (name="CUSTOMER_TYPE_CAPTION")
	private String customerTypeCaption;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerTypeCaption() {
		return customerTypeCaption;
	}

	public void setCustomerTypeCaption(String customerTypeCaption) {
		this.customerTypeCaption = customerTypeCaption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customerTypeCaption == null) ? 0 : customerTypeCaption.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CustomerType other = (CustomerType) obj;
		if (customerTypeCaption == null) {
			if (other.customerTypeCaption != null)
				return false;
		} else if (!customerTypeCaption.equals(other.customerTypeCaption))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerType [id=" + id + ", customerTypeCaption=" + customerTypeCaption + "]";
	}
	
	
	
}
