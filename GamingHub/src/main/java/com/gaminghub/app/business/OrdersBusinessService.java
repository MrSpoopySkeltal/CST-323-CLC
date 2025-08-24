package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.OrdersDataService;
import com.gaminghub.app.data.entity.OrderEntity;
import com.gaminghub.app.presentation.model.OrderModel;

/**
 * Service implementation for handling business logic related to orders.
 */
@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    OrdersDataService service;
    
    /**
     * Retrieves all orders.
     * 
     * @return List of OrderModel representing all orders
     */
    @Override
    public List<OrderModel> getOrders() {
        return service.findAll()
                      .stream()
                      .map(OrderEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves a subset of orders for pagination.
     * 
     * @param limit Number of orders to retrieve
     * @param offset Number of orders to skip before retrieval
     * @return List of OrderModel within the specified range
     */
    @Override
    public List<OrderModel> getOrdersInRange(int limit, int offset) {
        return service.findRange(limit, offset)
                      .stream()
                      .map(OrderEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves an order by its ID.
     * 
     * @param order_id The ID of the order to retrieve
     * @return OrderModel representing the order, or null if not found
     */
    @Override
    public OrderModel getOrderById(int order_id) {
        return service.findById(order_id).toModel();
    }

    /**
     * Adds a new order.
     * 
     * @param order The OrderModel to add
     * @return true if the order was added successfully, false otherwise
     */
    @Override
    public boolean addOrder(OrderModel order) {
        return service.create(order.toEntity());
    }

    /**
     * Updates an existing order.
     * 
     * @param order The OrderModel with updated data
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateOrder(OrderModel order) {
        return service.update(order.toEntity());
    }

    /**
     * Deletes an order by its ID.
     * 
     * @param order_id The ID of the order to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteOrder(int order_id) {
        return service.delete(order_id);
    }

    /**
     * Deletes an order by the given OrderModel.
     * 
     * @param order The OrderModel to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteOrder(OrderModel order) {
        return service.delete(order.toEntity());
    }

    /**
     * Retrieves the total count of orders.
     * 
     * @return The number of orders
     */
    @Override
    public int getOrderCount() {
        return service.getCount();
    }

}
