package com.cg.customer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
@NamedQueries({
@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
@NamedQuery(name = "getCustomerIds", query = "SELECT custId FROM Customer cust"),
@NamedQuery(name = "getCustomerbyId", query = "SELECT cust FROM Customer cust where cust.custId=:cId"),
@NamedQuery(name = "deleteCustomerById", query = "DELETE FROM Customer cust WHERE cust.custId=:cId"),
}) 
public class Customer {
	
	@Id
	@NotNull(message="Id is required")
	@Min(value=0,message="Can not be negative")
	private int custId;
	
	@NotEmpty(message="user name is required")
	private String custName;
	
	@NotNull(message="mobile is required")
	@Length(min=10,max=10,message="Phone Number should contain only 10 digits")
	/*@Pattern(regexp = "^[0-9]+$", message = "Phone Number should contain only 10 digits")*/
	private String mobile;
	@Email
	@NotEmpty(message="email is required")
	private String email;
	
	@NotNull(message="Date is required")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	private Date birthDate;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
