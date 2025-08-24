package com.gaminghub.app.data.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.CustomerModel;

/**
 * Represents the persistent entity for a customer, mapped to the {@code customers} table in the database.
 * <p>
 * This entity is used by the data access layer (e.g., Spring Data repositories) and includes mapping
 * annotations to bind class fields to table columns.
 * </p>
 *
 * <p>
 * This class can be converted to a {@link CustomerModel} for use in the presentation layer.
 * </p>
 *
 * @see CustomerModel
 */
@Table("customers")
public class CustomerEntity {

    /** Unique identifier for the customer (primary key) */
    @Id
    @Column("customer_id")
    int customer_id;

    /** Customer's first name */
    @Column("first_name")
    String first_name;

    /** Customer's last name */
    @Column("last_name")
    String last_name;

    /** Customer's email address */
    @Column("email")
    String email;

    /** Timestamp indicating when the customer was registered */
    @Column("created_at")
    Timestamp created_at;

    /**
     * Constructs a new {@code CustomerEntity} with all required fields.
     *
     * @param customer_id the unique ID of the customer
     * @param first_name  the customer's first name
     * @param last_name   the customer's last name
     * @param email       the customer's email address
     * @param created_at  timestamp of when the customer record was created
     */
    public CustomerEntity(int customer_id, String first_name, String last_name, String email, Timestamp created_at) {
        super();
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.created_at = created_at;
    }

    /** @return the customer's unique ID */
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

    /** @return the customer's email */
    public String getEmail() {
        return email;
    }

    /** @param email the email to set */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the timestamp when the customer was created */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /** @param created_at the creation timestamp to set */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Converts this entity to a {@link CustomerModel} for use in the presentation layer.
     *
     * @return a new {@code CustomerModel} containing the same data
     */
    public CustomerModel toModel() {
        return new CustomerModel(
            this.customer_id,
            this.first_name,
            this.last_name,
            this.email,
            this.created_at
        );
    }
}
