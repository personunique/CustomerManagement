package com.cg.customer.service;

import java.util.List;

import com.cg.customer.model.Customer;

public interface ICustomerService {

	void addDetails(Customer bean);

	Customer retrieveById(int custId);

	List<Customer> retrieveDetails();

	void deleteDetails(Customer bean);

	Customer getEmpId(Customer id);

	List<Integer> retrieveIds();

	Customer update(Customer cust);

	
}
