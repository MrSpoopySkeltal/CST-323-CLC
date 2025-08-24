package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.CustomerModel;

/**
 * Interface defining business operations related to customers.
 */
public interface CustomersBusinessServiceInterface {

    /**
     * Retrieves all customers.
     * 
     * @return List of all CustomerModel objects
     */
    List<CustomerModel> getCustomers();

    /**
     * Retrieves a range of customers for pagination.
     * 
     * @param limit  Number of customers to retrieve
     * @param offset Number of customers to skip before starting retrieval
     * @return List of CustomerModel objects within the specified range
     */
    List<CustomerModel> getCustomersInRange(int limit, int offset);

    /**
     * Retrieves a customer by their unique ID.
     * 
     * @param customer_id The ID of the customer to retrieve
     * @return The CustomerModel matching the ID, or null if not found
     */
    CustomerModel getCustomerById(int customer_id);

    /**
     * Adds a new customer.
     * 
     * @param customer The CustomerModel to add
     * @return true if the customer was added successfully, false otherwise
     */
    boolean addCustomer(CustomerModel customer);

    /**
     * Updates an existing customer.
     * 
     * @param customer The CustomerModel with updated information
     * @return true if the update was successful, false otherwise
     */
    boolean updateCustomer(CustomerModel customer);

    /**
     * Deletes a customer by their unique ID.
     * 
     * @param customer_id The ID of the customer to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteCustomer(int customer_id);

    /**
     * Deletes a customer.
     * 
     * @param customer The CustomerModel to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteCustomer(CustomerModel customer);

    /**
     * Retrieves the total count of customers.
     * 
     * @return The number of customers
     */
    int getCustomerCount();
}
