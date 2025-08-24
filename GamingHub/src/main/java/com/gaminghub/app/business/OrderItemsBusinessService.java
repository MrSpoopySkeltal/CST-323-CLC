package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.OrderItemsDataService;
import com.gaminghub.app.data.entity.OrderItemEntity;
import com.gaminghub.app.presentation.model.OrderItemModel;

/**
 * Service implementation for handling business logic related to order items.
 */
@Service
public class OrderItemsBusinessService implements OrderItemsBusinessServiceInterface {

    @Autowired
    OrderItemsDataService service;
    
    /**
     * Retrieves all order items.
     * 
     * @return List of OrderItemModel representing all order items
     */
    @Override
    public List<OrderItemModel> getOrderItems() {
        return service.findAll()
                      .stream()
                      .map(OrderItemEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves a subset of order items for pagination.
     * 
     * @param limit Number of order items to retrieve
     * @param offset Number of order items to skip before retrieval
     * @return List of OrderItemModel within the specified range
     */
    @Override
    public List<OrderItemModel> getOrderItemsInRange(int limit, int offset) {
        return service.findRange(limit, offset)
                      .stream()
                      .map(OrderItemEntity::toModel)
                      .collect(Collectors.toList());
    }
    
    /**
     * Retrieves order items filtered by the given order ID.
     * 
     * @param order_id The ID of the order to filter by
     * @return List of OrderItemModel belonging to the specified order
     */
    @Override
    public List<OrderItemModel> getOrderItemsByOrderId(int order_id) {
        return service.findByOrderId(order_id)
                      .stream()
                      .map(OrderItemEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves an order item by its ID.
     * 
     * @param order_item_id The ID of the order item to retrieve
     * @return OrderItemModel representing the order item, or null if not found
     */
    @Override
    public OrderItemModel getOrderItemById(int order_item_id) {
        return service.findById(order_item_id).toModel();
    }

    /**
     * Adds a new order item.
     * 
     * @param orderItem The OrderItemModel to add
     * @return true if the order item was added successfully, false otherwise
     */
    @Override
    public boolean addOrderItem(OrderItemModel orderItem) {
        return service.create(orderItem.toEntity());
    }

    /**
     * Updates an existing order item.
     * 
     * @param orderItem The OrderItemModel with updated data
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateOrderItem(OrderItemModel orderItem) {
        return service.update(orderItem.toEntity());
    }

    /**
     * Deletes an order item by its ID.
     * 
     * @param order_item_id The ID of the order item to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteOrderItem(int order_item_id) {
        return service.delete(order_item_id);
    }

    /**
     * Deletes an order item by the given OrderItemModel.
     * 
     * @param orderItem The OrderItemModel to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteOrderItem(OrderItemModel orderItem) {
        return service.delete(orderItem.toEntity());
    }

    /**
     * Retrieves the total count of order items.
     * 
     * @return The number of order items
     */
    @Override
    public int getOrderItemCount() {
        return service.getCount();
    }

}
