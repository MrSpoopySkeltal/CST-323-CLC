package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderModel;

public interface OrdersBusinessServiceInterface {
	List<OrderModel> getOrders();
	List<OrderModel> getOrdersInRange(int limit, int offset);
	OrderModel getOrderById(int order_id);
	boolean addOrder(OrderModel order);
	boolean updateOrder(OrderModel order);
	boolean deleteOrder(int order_id);
	boolean deleteOrder(OrderModel order);
	int getOrderCount();
}
