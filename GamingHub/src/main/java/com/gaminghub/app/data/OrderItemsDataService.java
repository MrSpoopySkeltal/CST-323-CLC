package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.OrderItemEntity;
import com.gaminghub.app.data.mapper.OrderItemRowMapper;
import com.gaminghub.app.data.repository.OrderItemsRepository;

/**
 * Service class for managing OrderItemEntity data access.
 * Implements CRUD operations using Spring Data repository and JdbcTemplate.
 */
@Service
public class OrderItemsDataService implements OrderItemsDataAccessInterface {

    @Autowired
    OrderItemsRepository orderItemsRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * Retrieves all order items from the database.
     * 
     * @return List of all OrderItemEntity objects
     */
    @Override
    public List<OrderItemEntity> findAll() {
        return orderItemsRepository.findAll();
    }

    /**
     * Retrieves a range of order items with pagination.
     * 
     * @param limit  maximum number of records to return
     * @param offset starting position of records
     * @return List of OrderItemEntity objects within the specified range
     */
    @Override
    public List<OrderItemEntity> findRange(int limit, int offset) {
        String sql = "SELECT * FROM order_items LIMIT ? OFFSET ?";
        List<OrderItemEntity> results = new ArrayList<OrderItemEntity>();
        try {
            Iterable<OrderItemEntity> iterable = jdbcTemplate.query(sql, new OrderItemRowMapper(), limit, offset);
            iterable.forEach(results::add);
        } catch (DataAccessException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
        return results;
    }

    /**
     * Finds a specific order item by its ID.
     * 
     * @param id The order item ID to search for
     * @return The OrderItemEntity if found, or null if not found
     */
    @Override
    public OrderItemEntity findById(int id) {
        try {
            OrderItemEntity e = orderItemsRepository.findById(id).get();
            return e;
        } catch (NoSuchElementException e) { e.printStackTrace(); }
        return null;
    }

    /**
     * Creates a new order item record in the database.
     * 
     * @param t The OrderItemEntity to create
     * @return true if creation succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean create(OrderItemEntity t) {
        String sql = "INSERT INTO order_items (order_id, quantity, units_price, game_id) VALUES (?, ?, ?, ?)";
        try {
            int num = jdbcTemplate.update(sql, t.getOrder_id(), t.getQuantity(), t.getUnits_price(), t.getGame_id());
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Updates an existing order item record in the database.
     * 
     * @param t The OrderItemEntity with updated data
     * @return true if update succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean update(OrderItemEntity t) {
        String sql = "UPDATE order_items SET order_id = ?, quantity = ?, units_price = ?, game_id = ? WHERE order_item_id = ?";
        try {
            int num = jdbcTemplate.update(sql, t.getOrder_id(), t.getQuantity(), t.getUnits_price(), t.getGame_id(), t.getOrder_item_id());
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Deletes an order item from the database using the OrderItemEntity object.
     * 
     * @param t The OrderItemEntity to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(OrderItemEntity t) {
        return delete(t.getOrder_item_id());
    }

    /**
     * Deletes an order item from the database by its ID.
     * 
     * @param id The ID of the order item to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM order_items WHERE order_item_id = ?";
        try {
            int num = jdbcTemplate.update(sql, id);
            return num == 1;
        } catch (DataAccessException e) { e.printStackTrace(); throw e; }
        catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    /**
     * Retrieves the total count of order item records in the database.
     * 
     * @return The number of order item records
     */
    @Override
    public int getCount() {
        return (int)orderItemsRepository.count();
    }

    /**
     * Finds all order items associated with a specific order ID.
     * 
     * @param order_id The ID of the order to find order items for
     * @return List of OrderItemEntity objects linked to the specified order
     */
    @Override
    public List<OrderItemEntity> findByOrderId(int order_id) {
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        List<OrderItemEntity> results = new ArrayList<OrderItemEntity>();
        try {
            Iterable<OrderItemEntity> iterable = jdbcTemplate.query(sql, new OrderItemRowMapper(), order_id);
            iterable.forEach(results::add);
        } catch (DataAccessException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }
        return results;
    }

}
