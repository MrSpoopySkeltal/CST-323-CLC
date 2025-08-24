package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.CustomersDataService;
import com.gaminghub.app.data.entity.CustomerEntity;
import com.gaminghub.app.presentation.model.CustomerModel;

/**
 * Service implementation for handling business logic related to customers.
 */
@Service
public class CustomersBusinessService implements CustomersBusinessServiceInterface {

    @Autowired
    CustomersDataService service;
    
    /**
     * Retrieves all customers.
     * 
     * @return List of CustomerModel objects representing all customers
     */
    @Override
    public List<CustomerModel> getCustomers() {
        return service.findAll()
                      .stream()
                      .map(CustomerEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves customers within a specified range for pagination.
     * 
     * @param limit  Number of customers to retrieve
     * @param offset Number of customers to skip before retrieval
     * @return List of CustomerModel objects within the specified range
     */
    @Override
    public List<CustomerModel> getCustomersInRange(int limit, int offset) {
        return service.findRange(limit, offset)
                      .stream()
                      .map(CustomerEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves a customer by their ID.
     * 
     * @param customer_id The ID of the customer to retrieve
     * @return CustomerModel representing the customer with the given ID, or null if not found
     */
    @Override
    public CustomerModel getCustomerById(int customer_id) {
        return service.findById(customer_id).toModel();
    }

    /**
     * Adds a new customer.
     * 
     * @param customer The CustomerModel to add
     * @return true if the customer was added successfully, false otherwise
     */
    @Override
    public boolean addCustomer(CustomerModel customer) {
        return service.create(customer.toEntity());
    }

    /**
     * Updates an existing customer.
     * 
     * @param customer The CustomerModel with updated data
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateCustomer(CustomerModel customer) {
        return service.update(customer.toEntity());
    }

    /**
     * Deletes a customer by their ID.
     * 
     * @param customer_id The ID of the customer to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteCustomer(int customer_id) {
        return service.delete(customer_id);
    }

    /**
     * Deletes a customer by the given CustomerModel.
     * 
     * @param customer The CustomerModel to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteCustomer(CustomerModel customer) {
        return service.delete(customer.toEntity());
    }

    /**
     * Retrieves the total count of customers.
     * 
     * @return The number of customers
     */
    @Override
    public int getCustomerCount() {
        return service.getCount();
    }

}
