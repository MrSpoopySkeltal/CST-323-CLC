package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.OrderEntity;

/**
 * Represents a domain model for an order in the system.
 * <p>
 * This class maps to the `orders` table and contains details such as
 * order ID, total amount, customer ID, and creation timestamp.
 * It is used within the presentation layer of the application and can
 * be converted to a corresponding {@link OrderEntity} for persistence.
 * </p>
 * 
 * @author COvermyer
 */
public class OrderModel {

    /** Unique identifier for the order */
    int order_id;

    /** Total monetary value of the order */
    float total_amount;

    /** Identifier of the customer who placed the order */
    int customer_id;

    /** Timestamp indicating when the order was created */
    Timestamp created_at;

    /**
     * Constructs a new {@code OrderModel} instance with the provided details.
     *
     * @param order_id     the unique ID of the order
     * @param total_amount the total amount of the order
     * @param customer_id  the ID of the customer who placed the order
     * @param created_at   the timestamp when the order was created
     */
    public OrderModel(int order_id, float total_amount, int customer_id, Timestamp created_at) {
        super();
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.customer_id = customer_id;
        this.created_at = created_at;
    }

    /**
     * Returns the order ID.
     *
     * @return the order ID
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Sets the order ID.
     *
     * @param order_id the order ID to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Returns the total amount of the order.
     *
     * @return the total amount
     */
    public float getTotal_amount() {
        return total_amount;
    }

    /**
     * Sets the total amount of the order.
     *
     * @param total_amount the amount to set
     */
    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * Returns the ID of the customer who placed the order.
     *
     * @return the customer ID
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * Sets the customer ID.
     *
     * @param customer_id the customer ID to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * Returns the timestamp when the order was created.
     *
     * @return the creation timestamp
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * Sets the timestamp of when the order was created.
     *
     * @param created_at the creation timestamp to set
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Converts this model to its corresponding {@link OrderEntity} representation.
     *
     * @return an {@code OrderEntity} with the same field values
     */
    public OrderEntity toEntity() {
        return new OrderEntity(
            this.order_id,
            this.total_amount,
            this.customer_id,
            this.created_at
        );
    }

    /**
     * Returns a string representation of the order model.
     *
     * @return a string containing order details
     */
    @Override
    public String toString() {
        return "OrderModel [order_id=" + order_id + ", total_amount=" + total_amount + ", customer_id=" + customer_id
                + ", created_at=" + created_at + "]";
    }
}
