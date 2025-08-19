package com.gaminghub.app.data;

import java.util.List;

import com.gaminghub.app.data.entity.OrderItemEntity;

public interface OrderItemsDataAccessInterface extends DataAccessInterface<OrderItemEntity> {
	List<OrderItemEntity> findByOrderId(int order_id);
}
