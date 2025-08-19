package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.OrderItemsDataService;
import com.gaminghub.app.data.entity.OrderItemEntity;
import com.gaminghub.app.presentation.model.OrderItemModel;

@Service
public class OrderItemsBusinessService implements OrderItemsBusinessServiceInterface {

	@Autowired
	OrderItemsDataService service;
	
	@Override
	public List<OrderItemModel> getOrderItems() {
		return service.findAll()
					  .stream()
					  .map(OrderItemEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public List<OrderItemModel> getOrderItemsInRange(int limit, int offset) {
		return service.findRange(limit, offset)
					  .stream()
					  .map(OrderItemEntity::toModel)
					  .collect(Collectors.toList());
	}
	
	@Override
	public List<OrderItemModel> getOrderItemsByOrderId(int order_id) {
		return service.findByOrderId(order_id)
					  .stream()
					  .map(OrderItemEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public OrderItemModel getOrderItemById(int order_item_id) {
		return service.findById(order_item_id).toModel();
	}

	@Override
	public boolean addOrderItem(OrderItemModel orderItem) {
		return service.create(orderItem.toEntity());
	}

	@Override
	public boolean updateOrderItem(OrderItemModel orderItem) {
		return service.update(orderItem.toEntity());
	}

	@Override
	public boolean deleteOrderItem(int order_item_id) {
		return service.delete(order_item_id);
	}

	@Override
	public boolean deleteOrderItem(OrderItemModel orderItem) {
		return service.delete(orderItem.toEntity());
	}

	@Override
	public int getOrderItemCount() {
		return service.getCount();
	}

}
