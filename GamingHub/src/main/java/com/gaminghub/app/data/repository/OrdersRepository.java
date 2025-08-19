package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.OrderEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Integer>{
	
	@Override
	@Query(value="SELECT * FROM orders WHERE 1")
	public List<OrderEntity> findAll();
	
	@Override
	@Query(value="SELECT COUNT(*) FROM orders WHERE 1")
	public long count();
}
