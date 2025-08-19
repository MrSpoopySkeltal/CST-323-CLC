package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderItemModel;

public interface OrderItemsBusinessServiceInterface {
	List<OrderItemModel> getOrderItems();
	List<OrderItemModel> getOrderItemsInRange(int limit, int offset);
	List<OrderItemModel> getOrderItemsByOrderId(int order_id);
	OrderItemModel getOrderItemById(int order_item_id);
	boolean addOrderItem(OrderItemModel orderItem);
	boolean updateOrderItem(OrderItemModel orderItem);
	boolean deleteOrderItem(int order_item_id);
	boolean deleteOrderItem(OrderItemModel orderItem);
	int getOrderItemCount();
}
