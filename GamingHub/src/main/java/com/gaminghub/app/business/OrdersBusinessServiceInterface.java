package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderModel;

/**
 * Interface defining business operations related to orders.
 */
public interface OrdersBusinessServiceInterface {

    /**
     * Retrieves all orders.
     * 
     * @return List of all OrderModel objects
     */
    List<OrderModel> getOrders();

    /**
     * Retrieves a range of orders for pagination.
     * 
     * @param limit  Number of orders to retrieve
     * @param offset Number of orders to skip before starting retrieval
     * @return List of OrderModel objects within the specified range
     */
    List<OrderModel> getOrdersInRange(int limit, int offset);

    /**
     * Retrieves a single order by its unique ID.
     * 
     * @param order_id The ID of the order to retrieve
     * @return The OrderModel matching the ID, or null if not found
     */
    OrderModel getOrderById(int order_id);

    /**
     * Adds a new order.
     * 
     * @param order The OrderModel to add
     * @return true if the order was added successfully, false otherwise
     */
    boolean addOrder(OrderModel order);

    /**
     * Updates an existing order.
     * 
     * @param order The OrderModel with updated information
     * @return true if the update was successful, false otherwise
     */
    boolean updateOrder(OrderModel order);

    /**
     * Deletes an order by its unique ID.
     * 
     * @param order_id The ID of the order to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteOrder(int order_id);

    /**
     * Deletes an order.
     * 
     * @param order The OrderModel to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteOrder(OrderModel order);

    /**
     * Retrieves the total count of orders.
     * 
     * @return The number of orders
     */
    int getOrderCount();
}
