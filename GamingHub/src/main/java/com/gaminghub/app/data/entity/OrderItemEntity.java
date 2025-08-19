package com.gaminghub.app.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.OrderItemModel;

@Table("order_items")
public class OrderItemEntity {

	@Id
	@Column("order_item_id")
	int order_item_id;
	
	@Column("order_id")
	int order_id;
	
	@Column("quantity")
	int quantity;
	
	@Column("units_price")
	float units_price; // depreciate? --> Price can be calculated dynamically from (games.price * order_items.quantity)
	
	@Column("game_id")
	int game_id;

	public OrderItemEntity(int order_item_id, int order_id, int quantity, float units_price, int game_id) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.quantity = quantity;
		this.units_price = units_price;
		this.game_id = game_id;
	}

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnits_price() {
		return units_price;
	}

	public void setUnits_price(float units_price) {
		this.units_price = units_price;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	
	public OrderItemModel toModel()
	{
		return new OrderItemModel(
				this.order_item_id,
				this.order_id,
				this.quantity,
				this.units_price,
				this.game_id
				);
	}
}

