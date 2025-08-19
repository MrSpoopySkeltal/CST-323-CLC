package com.gaminghub.app.presentation.dto;

import com.gaminghub.app.presentation.model.CustomerModel;

public class CustomerViewModel {
	int customerId;
	String name;
	String email;
	
	public CustomerViewModel(CustomerModel customerModel)
	{
		this(customerModel.getCustomer_id(), customerModel.getFirst_name(), customerModel.getLast_name(), customerModel.getEmail());
	}
	
	public CustomerViewModel(int customerId, String firstName, String lastName, String email) {
		super();
		this.customerId = customerId;
		this.name = String.format("%s %s", firstName, lastName);
		this.email = email;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
