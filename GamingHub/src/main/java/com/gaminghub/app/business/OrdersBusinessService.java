package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.OrdersDataService;
import com.gaminghub.app.data.entity.OrderEntity;
import com.gaminghub.app.presentation.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	OrdersDataService service;
	
	@Override
	public List<OrderModel> getOrders() {
		return service.findAll()
					  .stream()
					  .map(OrderEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public List<OrderModel> getOrdersInRange(int limit, int offset) {
		return service.findRange(limit, offset)
					  .stream()
					  .map(OrderEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public OrderModel getOrderById(int order_id) {
		return service.findById(order_id).toModel();
	}

	@Override
	public boolean addOrder(OrderModel order) {
		return service.create(order.toEntity());
	}

	@Override
	public boolean updateOrder(OrderModel order) {
		return service.update(order.toEntity());
	}

	@Override
	public boolean deleteOrder(int order_id) {
		return service.delete(order_id);
	}

	@Override
	public boolean deleteOrder(OrderModel order) {
		return service.delete(order.toEntity());
	}

	@Override
	public int getOrderCount() {
		return service.getCount();
	}

}
