package com.rest.clarify.cases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.clarify.cases.entity.Cases;

@Repository
public interface CaseJdbcRepository extends CrudRepository<Cases, Integer>{
	
	@SuppressWarnings("unchecked")
	@Override
	public Cases save(Cases cases);

	public Cases findByCaseId(int id);
	
	public void deleteByCaseId(int id);

}
