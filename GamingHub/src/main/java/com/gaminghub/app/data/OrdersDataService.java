package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.OrderEntity;
import com.gaminghub.app.data.mapper.OrdersRowMapper;
import com.gaminghub.app.data.repository.OrdersRepository;

/**
 * Service class for managing OrderEntity data access.
 * Implements CRUD operations using both Spring Data repository and JdbcTemplate.
 */
@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {

    @Autowired
    OrdersRepository ordersRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * Retrieves all orders from the database.
     * 
     * @return List of all OrderEntity objects
     */
    @Override
    public List<OrderEntity> findAll() {
        return ordersRepository.findAll();
    }

    /**
     * Retrieves a range of orders with pagination.
     * 
     * @param limit maximum number of records to return
     * @param offset starting position of records
     * @return List of OrderEntity objects within the specified range
     */
    @Override
    public List<OrderEntity> findRange(int limit, int offset) {
        String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
        List<OrderEntity> results = new ArrayList<OrderEntity>();
        try {
            Iterable<OrderEntity> iterable = jdbcTemplate.query(sql, new OrdersRowMapper(), limit, offset);
            iterable.forEach(results::add);
        } catch (Exception e) { e.printStackTrace(); }
        return results;
    }

    /**
     * Finds a specific order by its ID.
     * 
     * @param id The order ID to search for
     * @return The OrderEntity if found, or null if not found
     */
    @Override
    public OrderEntity findById(int id) {
        try {
            OrderEntity e = ordersRepository.findById(id).get();
            return e;
        } catch (NoSuchElementException e) { e.printStackTrace(); }
        return null;
    }

    /**
     * Creates a new order record in the database.
     * 
     * @param t The OrderEntity to create
     * @return true if creation succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean create(OrderEntity t) {
        String sql = "INSERT INTO orders (total_amount, customer_id) VALUES (?, ?)";
        try {
            int num = jdbcTemplate.update(sql, t.getTotal_amount(), t.getCustomer_id());
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Updates an existing order record in the database.
     * 
     * @param t The OrderEntity with updated data
     * @return true if update succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean update(OrderEntity t) {
        String sql = "UPDATE orders SET total_amount = ?, customer_id = ?, created_at = ? WHERE order_id = ?";
        try {
            int num = jdbcTemplate.update(sql, t.getTotal_amount(), t.getCustomer_id(), t.getCreated_at(), t.getOrder_id());
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Deletes an order from the database using the OrderEntity object.
     * 
     * @param t The OrderEntity to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(OrderEntity t) {
        return delete(t.getOrder_id());
    }

    /**
     * Deletes an order from the database by its ID.
     * 
     * @param id The ID of the order to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try {
            int num = jdbcTemplate.update(sql, id);
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Retrieves the total count of order records in the database.
     * 
     * @return The number of order records
     */
    @Override
    public int getCount() {
        return (int)ordersRepository.count();
    }

}
