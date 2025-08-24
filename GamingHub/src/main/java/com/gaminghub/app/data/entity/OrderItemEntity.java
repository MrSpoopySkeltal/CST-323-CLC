package com.gaminghub.app.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.OrderItemModel;

/**
 * Represents an order item entity mapped to the {@code order_items} table in the database.
 * <p>
 * Each instance corresponds to a single item within an order, including details such as the quantity ordered,
 * the unit price at the time of purchase, and the associated game.
 * </p>
 * <p>
 * Note: The {@code units_price} field may be deprecated in the future because the price can be calculated dynamically
 * from the game's price multiplied by the quantity.
 * </p>
 * <p>
 * Provides conversion to the presentation layer model {@link OrderItemModel}.
 * </p>
 *
 * @see OrderItemModel
 */
@Table("order_items")
public class OrderItemEntity {

    /** Unique identifier for the order item (primary key) */
    @Id
    @Column("order_item_id")
    int order_item_id;

    /** Identifier of the order to which this item belongs */
    @Column("order_id")
    int order_id;

    /** Quantity of the game purchased in this order item */
    @Column("quantity")
    int quantity;

    /** Unit price of the game at the time of the order item creation */
    @Column("units_price")
    float units_price; // depreciate? --> Price can be calculated dynamically from (games.price * order_items.quantity)

    /** Identifier of the game associated with this order item */
    @Column("game_id")
    int game_id;

    /**
     * Constructs an OrderItemEntity with the specified attributes.
     *
     * @param order_item_id the unique ID of the order item
     * @param order_id      the ID of the order this item belongs to
     * @param quantity      the quantity ordered for this item
     * @param units_price   the unit price at the time of ordering
     * @param game_id       the ID of the game associated with this item
     */
    public OrderItemEntity(int order_item_id, int order_id, int quantity, float units_price, int game_id) {
        super();
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.units_price = units_price;
        this.game_id = game_id;
    }

    /** @return the unique order item ID */
    public int getOrder_item_id() {
        return order_item_id;
    }

    /** @param order_item_id the order item ID to set */
    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    /** @return the order ID this item belongs to */
    public int getOrder_id() {
        return order_id;
    }

    /** @param order_id the order ID to set */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /** @return the quantity ordered */
    public int getQuantity() {
        return quantity;
    }

    /** @param quantity the quantity to set */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** @return the unit price at the time of the order */
    public float getUnits_price() {
        return units_price;
    }

    /** @param units_price the unit price to set */
    public void setUnits_price(float units_price) {
        this.units_price = units_price;
    }

    /** @return the game ID associated with this order item */
    public int getGame_id() {
        return game_id;
    }

    /** @param game_id the game ID to set */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /**
     * Converts this entity into an {@link OrderItemModel} for use in the presentation layer.
     *
     * @return an OrderItemModel representing the same data as this entity
     */
    public OrderItemModel toModel() {
        return new OrderItemModel(
            this.order_item_id,
            this.order_id,
            this.quantity,
            this.units_price,
            this.game_id
        );
    }
}
