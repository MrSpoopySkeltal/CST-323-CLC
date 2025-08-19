package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.CustomerEntity;

@Repository
public interface CustomersRepository extends CrudRepository<CustomerEntity, Integer>{

	@Override
	@Query(value="SELECT * FROM customers WHERE 1")
	public List<CustomerEntity> findAll();
	
	@Override
	@Query(value="SELECT COUNT(*) FROM customers WHERE 1")
	public long count();
}
