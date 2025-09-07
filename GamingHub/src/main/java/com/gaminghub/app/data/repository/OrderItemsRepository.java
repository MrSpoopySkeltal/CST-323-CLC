package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.OrderItemEntity;

/**
 * Repository interface for performing CRUD operations on the {@code order_items} table.
 * <p>
 * Extends {@link CrudRepository} to provide standard methods for retrieving, counting,
 * saving, and deleting order item entities. Custom SQL queries are specified for the
 * {@code findAll} and {@code count} methods.
 * </p>
 * 
 * @see CrudRepository
 * @see OrderItemEntity
 */
@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItemEntity, Integer> {

    /**
     * Retrieves all order items from the database.
     * 
     * @return a list of all {@link OrderItemEntity} records
     */
    @Query("SELECT * FROM order_items WHERE 1")
    List<OrderItemEntity> findAll();

    /**
     * Counts the total number of order items in the database.
     * 
     * @return the number of order item records
     */
    @Query("SELECT COUNT(*) FROM order_items WHERE 1")
    long count();
}
