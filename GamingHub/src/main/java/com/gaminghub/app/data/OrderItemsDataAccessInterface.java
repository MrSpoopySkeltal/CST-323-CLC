package com.gaminghub.app.data;

import java.util.List;

import com.gaminghub.app.data.entity.OrderItemEntity;

/**
 * Data access interface for OrderItemEntity extending generic CRUD operations.
 */
public interface OrderItemsDataAccessInterface extends DataAccessInterface<OrderItemEntity> {

    /**
     * Finds all order items associated with a specific order ID.
     * 
     * @param order_id the ID of the order
     * @return a list of OrderItemEntity objects linked to the specified order
     */
    List<OrderItemEntity> findByOrderId(int order_id);
}
