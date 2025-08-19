package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.OrderItemEntity;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItemEntity, Integer>{

	@Override
	@Query(value="SELECT * FROM order_items WHERE 1")
	public List<OrderItemEntity> findAll();
	
	@Override
	@Query(value="SELECT COUNT(*) FROM order_items WHERE 1")
	public long count();
}
