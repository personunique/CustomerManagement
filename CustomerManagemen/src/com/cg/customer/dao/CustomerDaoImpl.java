package com.cg.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.customer.model.Customer;


@Repository
public class CustomerDaoImpl implements ICustomerDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addDetails(Customer bean) {
	entityManager.persist(bean);
			}

	@Override
	public List<Customer> retrieveDetails() {
		
		Query query = (Query) entityManager.createNamedQuery("getAllCustomers");
		@SuppressWarnings("unchecked")
		List<Customer> custList = query.getResultList();
		return custList;
	}

	@Override
	public Customer retrieveById(int custId){
		/*Customer customer = entityManager.find(Customer.class, custId);*/
		
		TypedQuery<Customer> query = entityManager.createNamedQuery("getCustomerbyId", Customer.class).
				setParameter("cId", custId);
		Customer customer =  query.getSingleResult();
		return customer;
		
	}

	@Override
	public void deleteDetails(Customer bean)
	{
		Query query = (Query) entityManager.createNamedQuery("deleteCustomerById");
		query.setParameter("cId", bean.getCustId());
		query.executeUpdate();
	//entityManager.remove(bean);
	}
	/*public void deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("deleteCustomerById");
		query.setParameter("cId", custId);
		query.executeUpdate();
	} */
	


	@Override
	public Customer getEmpId(Customer id) {
		if(id!=null){
			id = entityManager.merge(id);
			entityManager.flush();
			}
				return id;
		
	
	}

	@Override
	public List<Integer> retrieveIds() {
		
		Query query = entityManager.createNamedQuery("getCustomerIds", Integer.class);
		List idList = query.getResultList();
		return idList;
	}

	@Override
	public Customer update(Customer cust) {
		return entityManager.merge(cust);
		
	} 

	
	

	

	
	
	
}
