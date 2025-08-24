package com.gaminghub.app.presentation.model;

import com.gaminghub.app.data.entity.OrderItemEntity;

/**
 * Represents a domain model for an item within an order.
 * <p>
 * Each instance corresponds to a row in the `order_items` table and 
 * contains data related to a specific game purchased as part of an order, 
 * such as quantity, price per unit, and associated order and game IDs.
 * </p>
 * 
 * <p><strong>Note:</strong> The {@code units_price} field is potentially 
 * deprecated, as unit price could be dynamically calculated from 
 * {@code games.price * order_items.quantity}.</p>
 * 
 * @see OrderItemEntity
 * @author 
 */
public class OrderItemModel {

    /** Unique identifier for the order item */
    int order_item_id;

    /** ID of the order this item belongs to */
    int order_id;

    /** Quantity of the game ordered */
    int quantity;

    /** Unit price of the game at the time of order (possibly deprecated) */
    float units_price;

    /** ID of the game associated with this order item */
    int game_id;

    /**
     * Constructs an {@code OrderItemModel} with the given parameters.
     *
     * @param order_item_id unique ID of the order item
     * @param order_id      ID of the order this item belongs to
     * @param quantity      number of units of the game ordered
     * @param units_price   unit price of the game (at time of order)
     * @param game_id       ID of the game ordered
     */
    public OrderItemModel(int order_item_id, int order_id, int quantity, float units_price, int game_id) {
        super();
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.units_price = units_price;
        this.game_id = game_id;
    }

    /**
     * Returns the ID of the order item.
     *
     * @return the order item ID
     */
    public int getOrder_item_id() {
        return order_item_id;
    }

    /**
     * Sets the ID of the order item.
     *
     * @param order_item_id the order item ID to set
     */
    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    /**
     * Returns the ID of the associated order.
     *
     * @return the order ID
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Sets the ID of the associated order.
     *
     * @param order_id the order ID to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Returns the quantity of the game ordered.
     *
     * @return the quantity ordered
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the game ordered.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the unit price of the game.
     * <p><strong>Note:</strong> This may be deprecated in favor of dynamic calculation.</p>
     *
     * @return the unit price
     */
    public float getUnits_price() {
        return units_price;
    }

    /**
     * Sets the unit price of the game.
     *
     * @param units_price the unit price to set
     */
    public void setUnits_price(float units_price) {
        this.units_price = units_price;
    }

    /**
     * Returns the ID of the game associated with this order item.
     *
     * @return the game ID
     */
    public int getGame_id() {
        return game_id;
    }

    /**
     * Sets the ID of the game associated with this order item.
     *
     * @param game_id the game ID to set
     */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /**
     * Converts this model to a corresponding {@link OrderItemEntity}.
     *
     * @return an {@code OrderItemEntity} with the same values
     */
    public OrderItemEntity toEntity() {
        return new OrderItemEntity(
            this.order_item_id,
            this.order_id,
            this.quantity,
            this.units_price,
            this.game_id
        );
    }

    /**
     * Returns a string representation of this order item model.
     *
     * @return a string describing the order item
     */
    @Override
    public String toString() {
        return "OrderItemModel [order_item_id=" + order_item_id + ", order_id=" + order_id + ", quantity=" + quantity
                + ", units_price=" + units_price + ", game_id=" + game_id + "]";
    }
}
