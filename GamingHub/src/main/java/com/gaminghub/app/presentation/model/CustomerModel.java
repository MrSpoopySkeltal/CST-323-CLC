package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.CustomerEntity;

/**
 * Represents a domain model for a customer in the system.
 * <p>
 * This model mirrors the `customers` table and includes key customer information such as name, email, and the account creation timestamp.
 * It is primarily used in the presentation layer and can be converted to a {@link CustomerEntity} for persistence in the data layer.
 * </p>
 *
 * @see CustomerEntity
 */
public class CustomerModel {

    /** Unique identifier for the customer */
    int customer_id;

    /** First name of the customer */
    String first_name;

    /** Last name of the customer */
    String last_name;

    /** Email address of the customer */
    String email;

    /** Timestamp of when the customer record was created */
    Timestamp created_at;

    /**
     * Constructs a new {@code CustomerModel} with the given customer details.
     *
     * @param customer_id the unique ID of the customer
     * @param first_name  the customer's first name
     * @param last_name   the customer's last name
     * @param email       the customer's email address
     * @param created_at  timestamp when the customer was registered
     */
    public CustomerModel(int customer_id, String first_name, String last_name, String email, Timestamp created_at) {
        super();
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.created_at = created_at;
    }

    /** @return the unique ID of the customer */
    public int getCustomer_id() {
        return customer_id;
    }

    /** @param customer_id the customer ID to set */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /** @return the customer's first name */
    public String getFirst_name() {
        return first_name;
    }

    /** @param first_name the first name to set */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /** @return the customer's last name */
    public String getLast_name() {
        return last_name;
    }

    /** @param last_name the last name to set */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /** @return the customer's email address */
    public String getEmail() {
        return email;
    }

    /** @param email the email address to set */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the timestamp of when the customer was created */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /** @param created_at the creation timestamp to set */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Converts this model to its corresponding {@link CustomerEntity}.
     *
     * @return a {@code CustomerEntity} containing the same values
     */
    public CustomerEntity toEntity() {
        return new CustomerEntity(
            this.customer_id,
            this.first_name,
            this.last_name,
            this.email,
            this.created_at
        );
    }

    /**
     * Returns a string representation of the customer model.
     *
     * @return a string containing customer details
     */
    @Override
    public String toString() {
        return "CustomerModel [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
                + ", email=" + email + ", created_at=" + created_at + "]";
    }
}
