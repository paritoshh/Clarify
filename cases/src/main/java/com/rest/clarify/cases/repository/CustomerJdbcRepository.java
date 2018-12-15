package com.rest.clarify.cases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.clarify.cases.entity.Customer;

@Repository
public interface CustomerJdbcRepository extends CrudRepository<Customer, Integer>{
	
	public Customer findByCustomerId(Integer id);
	

}
