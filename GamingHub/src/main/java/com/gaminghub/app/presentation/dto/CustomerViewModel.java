package com.gaminghub.app.presentation.dto;

import com.gaminghub.app.presentation.model.CustomerModel;

/**
 * View model representing a customer for presentation purposes.
 * <p>
 * Combines customer details such as id, full name, and email in a format
 * suitable for the UI layer.
 * </p>
 */
public class CustomerViewModel {

    /** The unique identifier of the customer. */
    int customerId;

    /** The full name of the customer (first name + last name). */
    String name;

    /** The email address of the customer. */
    String email;

    /**
     * Constructs a CustomerViewModel from the given domain model.
     * 
     * @param customerModel the CustomerModel domain object to map from
     */
    public CustomerViewModel(CustomerModel customerModel) {
        this(customerModel.getCustomer_id(), customerModel.getFirst_name(), customerModel.getLast_name(), customerModel.getEmail());
    }

    /**
     * Constructs a CustomerViewModel with explicit fields.
     * 
     * @param customerId the customer's ID
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     * @param email the customer's email address
     */
    public CustomerViewModel(int customerId, String firstName, String lastName, String email) {
        super();
        this.customerId = customerId;
        this.name = String.format("%s %s", firstName, lastName);
        this.email = email;
    }

    /**
     * Gets the customer's unique identifier.
     * 
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer's unique identifier.
     * 
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the customer's full name.
     * 
     * @return the customer's full name (first + last name)
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's full name.
     * 
     * @param name the full name to set (usually "First Last")
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the customer's email address.
     * 
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the customer's email address.
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
