package com.gaminghub.app.presentation.dto;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderModel;

public class OrderViewModel {
	
	private OrderModel domainModel; // References the domain model.
	private CustomerViewModel customerModel;
	private List<OrderItemViewModel> items;
	private float totalAmount;

	
	public OrderViewModel(OrderModel domainModel, CustomerViewModel customerModel, List<OrderItemViewModel> orderItems)
	{
		this.domainModel = domainModel;
		this.customerModel = customerModel;
		this.items = orderItems; 
		this.totalAmount = this.calculateTotalAmount();
		
		System.out.println("Domain Price: " + domainModel.getTotal_amount());
		System.out.println("Calculated Price: " + totalAmount);
	}
	
	
	private float calculateTotalAmount()
	{
		float total = 0f;
		
		for (OrderItemViewModel o : items)
		{
			float price = o.getDomainGame().getPrice();
			int qty = o.getDomainOrderItem().getQuantity();
			
			total += (qty * price);
		}
		
		return total;
	}


	public CustomerViewModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerViewModel customer) {
		this.customerModel = customer;
	}
	public OrderModel getDomainModel() {
		return domainModel;
	}
	public void setDomainModel(OrderModel domainModel) {
		this.domainModel = domainModel;
	}
	public List<OrderItemViewModel> getItems() {
		return items;
	}
	public void setItems(List<OrderItemViewModel> items) {
		this.items = items;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
