package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.CustomerEntity;

public class CustomerModel {

	int customer_id;
	String first_name;
	String last_name;
	String email;
	Timestamp created_at;
	
	public CustomerModel(int customer_id, String first_name, String last_name, String email, Timestamp created_at) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.created_at = created_at;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	public CustomerEntity toEntity()
	{
		return new CustomerEntity(
				this.customer_id,
				this.first_name,
				this.last_name,
				this.email,
				this.created_at
				);
	}

	@Override
	public String toString() {
		return "CustomerModel [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", created_at=" + created_at + "]";
	}
	
	
}
