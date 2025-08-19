package com.gaminghub.app.presentation.dto;

import com.gaminghub.app.presentation.model.GameModel;
import com.gaminghub.app.presentation.model.OrderItemModel;

public class OrderItemViewModel {
	
	private OrderItemModel domainOrderItem;
	private GameModel domainGame;
	
	public OrderItemViewModel(OrderItemModel domainOrderItem, GameModel domainGame) {
		this.domainOrderItem = domainOrderItem;
		this.domainGame = domainGame;
	}

	public OrderItemModel getDomainOrderItem() {
		return domainOrderItem;
	}
	public void setDomainOrderItem(OrderItemModel domainOrderItem) {
		this.domainOrderItem = domainOrderItem;
	}
	public GameModel getDomainGame() {
		return domainGame;
	}
	public void setDomainGame(GameModel domainGame) {
		this.domainGame = domainGame;
	}
	
	
}
