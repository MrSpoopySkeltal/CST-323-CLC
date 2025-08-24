package com.gaminghub.app.presentation.dto;

import com.gaminghub.app.presentation.model.GameModel;
import com.gaminghub.app.presentation.model.OrderItemModel;

/**
 * View model representing an order item in the presentation layer.
 * <p>
 * Encapsulates the domain models for order item details and the associated game.
 * </p>
 */
public class OrderItemViewModel {
	
	/** The domain model representing the order item details. */
	private OrderItemModel domainOrderItem;
	
	/** The domain model representing the game associated with the order item. */
	private GameModel domainGame;
	
	/**
	 * Constructs an OrderItemViewModel with given domain order item and game models.
	 * 
	 * @param domainOrderItem the order item domain model
	 * @param domainGame the associated game domain model
	 */
	public OrderItemViewModel(OrderItemModel domainOrderItem, GameModel domainGame) {
		this.domainOrderItem = domainOrderItem;
		this.domainGame = domainGame;
	}

	/**
	 * Gets the domain order item model.
	 * 
	 * @return the domainOrderItem
	 */
	public OrderItemModel getDomainOrderItem() {
		return domainOrderItem;
	}

	/**
	 * Sets the domain order item model.
	 * 
	 * @param domainOrderItem the domainOrderItem to set
	 */
	public void setDomainOrderItem(OrderItemModel domainOrderItem) {
		this.domainOrderItem = domainOrderItem;
	}

	/**
	 * Gets the domain game model associated with this order item.
	 * 
	 * @return the domainGame
	 */
	public GameModel getDomainGame() {
		return domainGame;
	}

	/**
	 * Sets the domain game model associated with this order item.
	 * 
	 * @param domainGame the domainGame to set
	 */
	public void setDomainGame(GameModel domainGame) {
		this.domainGame = domainGame;
	}
}
