package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.OrderEntity;

public class OrderModel {

	int order_id;
	float total_amount;
	int customer_id;
	Timestamp created_at;
	
	public OrderModel(int order_id, float total_amount, int customer_id, Timestamp created_at) {
		super();
		this.order_id = order_id;
		this.total_amount = total_amount;
		this.customer_id = customer_id;
		this.created_at = created_at;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	public OrderEntity toEntity()
	{
		return new OrderEntity(
				this.order_id,
				this.total_amount,
				this.customer_id,
				this.created_at
				);
	}

	@Override
	public String toString() {
		return "OrderModel [order_id=" + order_id + ", total_amount=" + total_amount + ", customer_id=" + customer_id
				+ ", created_at=" + created_at + "]";
	}
	
	
}
