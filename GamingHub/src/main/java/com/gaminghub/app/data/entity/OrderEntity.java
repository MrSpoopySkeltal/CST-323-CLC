package com.gaminghub.app.data.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.OrderModel;

@Table("orders")
public class OrderEntity {

	@Id
	@Column("order_id")
	int order_id;
	
	@Column("total_amount")
	float total_amount;
	
	@Column("customer_id")
	int customer_id;
	
	@Column("created_at")
	Timestamp created_at;

	public OrderEntity(int order_id, float total_amount, int customer_id, Timestamp created_at) {
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
	
	public OrderModel toModel()
	{
		return new OrderModel(
				this.order_id,
				this.total_amount,
				this.customer_id,
				this.created_at
				);				
	}
}
