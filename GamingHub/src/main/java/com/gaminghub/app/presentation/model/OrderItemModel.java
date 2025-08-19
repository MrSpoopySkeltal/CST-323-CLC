package com.gaminghub.app.presentation.model;

import com.gaminghub.app.data.entity.OrderItemEntity;

public class OrderItemModel {
	
	int order_item_id;
	int order_id;
	int quantity;
	float units_price; // depreciate? --> Price can be calculated dynamically from (games.price * order_items.quantity)
	int game_id;
	
	public OrderItemModel(int order_item_id, int order_id, int quantity, float units_price, int game_id) {
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
	
	public OrderItemEntity toEntity()
	{
		return new OrderItemEntity(
				this.order_item_id,
				this.order_id,
				this.quantity,
				this.units_price,
				this.game_id
				);
	}

	@Override
	public String toString() {
		return "OrderItemModel [order_item_id=" + order_item_id + ", order_id=" + order_id + ", quantity=" + quantity
				+ ", units_price=" + units_price + ", game_id=" + game_id + "]";
	}
	
	
}

