package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.CustomerEntity;
import com.gaminghub.app.data.mapper.CustomerRowMapper;
import com.gaminghub.app.data.repository.CustomersRepository;


/**
 * Service class for managing CustomerEntity data access.
 * Implements CRUD operations using Spring Data repository and JdbcTemplate.
 */
@Service
public class CustomersDataService implements DataAccessInterface<CustomerEntity>{

    @Autowired
    CustomersRepository customersRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * Retrieves all customers from the database.
     * 
     * @return List of all CustomerEntity objects
     */
    @Override
    public List<CustomerEntity> findAll() {
        return customersRepository.findAll();
    }

    /**
     * Retrieves a range of customers with pagination.
     * 
     * @param limit  Number of results to display
     * @param offset How many entities to ignore before beginning selection
     * @return List of CustomerEntity objects within the specified range
     */
    @Override
    public List<CustomerEntity> findRange(int limit, int offset) {
        String sql = "SELECT * FROM customers LIMIT ? OFFSET ?";
        List<CustomerEntity> results = new ArrayList<CustomerEntity>();
        try {
            Iterable<CustomerEntity> customersIterable = jdbcTemplate.query(sql, new CustomerRowMapper(), limit, offset);
            customersIterable.forEach(results::add);
        } catch (DataAccessException e) { 
            e.printStackTrace();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Finds a customer by its unique ID.
     * 
     * @param id The ID of the customer to find
     * @return The CustomerEntity if found, or null if not found
     */
    @Override
    public CustomerEntity findById(int id) {
        try {
            CustomerEntity e = customersRepository.findById(id).get();
            return e;
        } catch (NoSuchElementException e) { 
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a new customer record in the database.
     * 
     * @param t The CustomerEntity to create
   
     */
    @Transactional
    @Override
    public boolean create(CustomerEntity t) {
        String sql = "INSERT INTO customers (first_name, last_name, email) VALUES (?, ?, ?)";
        try {
            int num = jdbcTemplate.update(sql, t.getFirst_name(), t.getLast_name(), t.getEmail());
            return num == 1;
        } catch (DataAccessException e) { 
            e.printStackTrace(); 
            throw e; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    /**
     * Updates an existing customer record in the database.
     * 
     * @param t The CustomerEntity with updated data

     */
    @Transactional
    @Override
    public boolean update(CustomerEntity t) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, created_at = ? WHERE customer_id = ?";
        try {
            int num = jdbcTemplate.update(sql, t.getFirst_name(), t.getLast_name(), t.getEmail(), t.getCreated_at(), t.getCustomer_id());
            return num == 1;
        } catch (DataAccessException e) { 
            e.printStackTrace(); 
            throw e; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    /**
     * Deletes a customer from the database using the CustomerEntity object.
     * 
     * @param t The CustomerEntity to delete
     * true
     */
    @Transactional
    @Override
    public boolean delete(CustomerEntity t) {
        return delete(t.getCustomer_id());
    }

    /**
     * Deletes a customer from the database by its ID.
     * 
     * @param id The ID of the customer to delete
     * true
     */
    @Transactional
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try {
            int num = jdbcTemplate.update(sql, id);
            return num == 1;
        } catch (DataAccessException e) { 
            e.printStackTrace(); 
            throw e; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    /**
     * Returns the total number of customers in the database.
     * 
     * @return The count of customer records
     */
    @Override
    public int getCount() {
        return (int)customersRepository.count();
    }

}
