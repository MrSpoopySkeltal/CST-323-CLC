package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.OrderEntity;

/**
 * Repository interface for performing CRUD operations on the {@code orders} table.
 * <p>
 * Extends {@link CrudRepository} to provide standard methods for retrieving, counting,
 * saving, and deleting order entities. Custom SQL queries are provided for the
 * {@code findAll} and {@code count} methods.
 * </p>
 * 
 * @see CrudRepository
 * @see OrderEntity
 */
@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> {

    /**
     * Retrieves all orders from the database.
     * 
     * @return a list of all {@link OrderEntity} records
     */
    @Query("SELECT * FROM orders WHERE 1")
    List<OrderEntity> findAll();

    /**
     * Counts the total number of orders in the database.
     * 
     * @return the number of order records
     */
    @Query("SELECT COUNT(*) FROM orders WHERE 1")
    long count();
}
