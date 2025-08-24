package com.gaminghub.app.data.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.OrderModel;

/**
 * Represents the persistent entity for an order, mapped to the {@code orders} table in the database.
 * <p>
 * This class is part of the data access layer and is used for database operations involving orders.
 * It corresponds directly to the columns in the {@code orders} table.
 * </p>
 * <p>
 * Can be converted to a {@link OrderModel} for use in the presentation layer.
 * </p>
 *
 * @see OrderModel
 */
@Table("orders")
public class OrderEntity {

    /** Unique identifier for the order (primary key) */
    @Id
    @Column("order_id")
    int order_id;

    /** Total monetary amount for the order */
    @Column("total_amount")
    float total_amount;

    /** Identifier of the customer who placed the order */
    @Column("customer_id")
    int customer_id;

    /** Timestamp when the order was created */
    @Column("created_at")
    Timestamp created_at;

    /**
     * Constructs an OrderEntity with the specified details.
     *
     * @param order_id     the unique order ID
     * @param total_amount the total amount for the order
     * @param customer_id  the customer ID who placed the order
     * @param created_at   timestamp when the order was created
     */
    public OrderEntity(int order_id, float total_amount, int customer_id, Timestamp created_at) {
        super();
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.customer_id = customer_id;
        this.created_at = created_at;
    }

    /** @return the order ID */
    public int getOrder_id() {
        return order_id;
    }

    /** @param order_id the order ID to set */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /** @return the total amount for the order */
    public float getTotal_amount() {
        return total_amount;
    }

    /** @param total_amount the total amount to set */
    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    /** @return the customer ID who placed the order */
    public int getCustomer_id() {
        return customer_id;
    }

    /** @param customer_id the customer ID to set */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /** @return the timestamp when the order was created */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /** @param created_at the creation timestamp to set */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Converts this entity to an {@link OrderModel} instance suitable for the presentation layer.
     *
     * @return an OrderModel with the same data
     */
    public OrderModel toModel() {
        return new OrderModel(
            this.order_id,
            this.total_amount,
            this.customer_id,
            this.created_at
        );
    }
}
