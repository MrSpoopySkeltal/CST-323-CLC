package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query; 
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

    @Query("SELECT * FROM customers")
    List<CustomerEntity> findAll();

    @Query("SELECT COUNT(*) FROM customers")
    long count();
}