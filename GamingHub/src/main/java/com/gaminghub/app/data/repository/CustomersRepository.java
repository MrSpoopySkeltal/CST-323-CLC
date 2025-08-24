package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.CustomerEntity;

/**
 * Repository interface for performing CRUD operations on the {@code customers} table.
 * <p>
 * Extends {@link CrudRepository} to provide standard methods for
 * retrieving, counting, saving, and deleting customer entities.
 * Custom SQL queries are defined for {@code findAll} and {@code count} methods.
 * </p>
 * 
 * @see CrudRepository
 * @see CustomerEntity
 */
@Repository
public interface CustomersRepository extends CrudRepository<CustomerEntity, Integer> {

    /**
     * Retrieves all customers from the database.
     * 
     * @return a list of all {@link CustomerEntity} records
     */
    @Override
    @Query(value = "SELECT * FROM customers WHERE 1")
    List<CustomerEntity> findAll();

    /**
     * Counts the total number of customers in the database.
     * 
     * @return the number of customer records
     */
    @Override
    @Query(value = "SELECT COUNT(*) FROM customers WHERE 1")
    long count();
}
