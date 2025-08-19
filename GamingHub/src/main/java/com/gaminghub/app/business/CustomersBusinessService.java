package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.CustomersDataService;
import com.gaminghub.app.data.entity.CustomerEntity;
import com.gaminghub.app.presentation.model.CustomerModel;

@Service
public class CustomersBusinessService implements CustomersBusinessServiceInterface {

	@Autowired
	CustomersDataService service;
	
	@Override
	public List<CustomerModel> getCustomers() {
		return service.findAll()
					  .stream()
					  .map(CustomerEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public List<CustomerModel> getCustomersInRange(int limit, int offset) {
		return service.findRange(limit, offset)
					  .stream()
					  .map(CustomerEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public CustomerModel getCustomerById(int customer_id) {
		return service.findById(customer_id).toModel();
	}

	@Override
	public boolean addCustomer(CustomerModel customer) {
		return service.create(customer.toEntity());
	}

	@Override
	public boolean updateCustomer(CustomerModel customer) {
		return service.update(customer.toEntity());
	}

	@Override
	public boolean deleteCustomer(int customer_id) {
		return service.delete(customer_id);
	}

	@Override
	public boolean deleteCustomer(CustomerModel customer) {
		return service.delete(customer.toEntity());
	}

	@Override
	public int getCustomerCount() {
		return service.getCount();
	}

}
