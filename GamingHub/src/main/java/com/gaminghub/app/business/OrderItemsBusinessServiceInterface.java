package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderItemModel;

/**
 * Interface defining business operations related to order items.
 */
public interface OrderItemsBusinessServiceInterface {

    /**
     * Retrieves all order items.
     * 
     * @return List of all OrderItemModel objects
     */
    List<OrderItemModel> getOrderItems();

    /**
     * Retrieves a range of order items for pagination.
     * 
     * @param limit  Number of order items to retrieve
     * @param offset Number of order items to skip before starting retrieval
     * @return List of OrderItemModel objects within the specified range
     */
    List<OrderItemModel> getOrderItemsInRange(int limit, int offset);

    /**
     * Retrieves all order items associated with a specific order ID.
     * 
     * @param order_id The ID of the order whose items are to be retrieved
     * @return List of OrderItemModel objects belonging to the specified order
     */
    List<OrderItemModel> getOrderItemsByOrderId(int order_id);

    /**
     * Retrieves a single order item by its unique ID.
     * 
     * @param order_item_id The ID of the order item to retrieve
     * @return The OrderItemModel matching the ID, or null if not found
     */
    OrderItemModel getOrderItemById(int order_item_id);

    /**
     * Adds a new order item.
     * 
     * @param orderItem The OrderItemModel to add
     * @return true if the order item was added successfully, false otherwise
     */
    boolean addOrderItem(OrderItemModel orderItem);

    /**
     * Updates an existing order item.
     * 
     * @param orderItem The OrderItemModel with updated information
     * @return true if the update was successful, false otherwise
     */
    boolean updateOrderItem(OrderItemModel orderItem);

    /**
     * Deletes an order item by its unique ID.
     * 
     * @param order_item_id The ID of the order item to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteOrderItem(int order_item_id);

    /**
     * Deletes an order item.
     * 
     * @param orderItem The OrderItemModel to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteOrderItem(OrderItemModel orderItem);

    /**
     * Retrieves the total count of order items.
     * 
     * @return The number of order items
     */
    int getOrderItemCount();
}
