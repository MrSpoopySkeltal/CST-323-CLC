package com.gaminghub.app.presentation.dto;

import java.util.List;

import com.gaminghub.app.presentation.model.OrderModel;

/**
 * View model representing an order, combining domain data with associated customer
 * and order item details for presentation purposes.
 * <p>
 * This class wraps an {@link OrderModel} domain object and enriches it with
 * {@link CustomerViewModel} and a list of {@link OrderItemViewModel} objects.
 * It also calculates the total order amount dynamically based on the associated order items.
 * </p>
 */
public class OrderViewModel {
	
	/** The underlying domain model for the order. */
	private OrderModel domainModel;

	/** The customer details associated with the order. */
	private CustomerViewModel customerModel;

	/** The list of order items included in the order. */
	private List<OrderItemViewModel> items;

	/** The total amount of the order, calculated from the order items. */
	private float totalAmount;

	/**
	 * Constructs an OrderViewModel with the specified domain model, customer model,
	 * and order items.
	 * 
	 * @param domainModel the underlying order domain model
	 * @param customerModel the customer associated with the order
	 * @param orderItems the list of order items in this order
	 */
	public OrderViewModel(OrderModel domainModel, CustomerViewModel customerModel, List<OrderItemViewModel> orderItems) {
		this.domainModel = domainModel;
		this.customerModel = customerModel;
		this.items = orderItems; 
		this.totalAmount = this.calculateTotalAmount();
		
		System.out.println("Domain Price: " + domainModel.getTotal_amount());
		System.out.println("Calculated Price: " + totalAmount);
	}

	/**
	 * Calculates the total amount for the order by summing the product of quantity
	 * and price for each order item.
	 * 
	 * @return the calculated total amount
	 */
	private float calculateTotalAmount() {
		float total = 0f;
		for (OrderItemViewModel o : items) {
			float price = o.getDomainGame().getPrice();
			int qty = o.getDomainOrderItem().getQuantity();
			total += (qty * price);
		}
		return total;
	}

	/**
	 * Gets the customer view model associated with this order.
	 * 
	 * @return the customer view model
	 */
	public CustomerViewModel getCustomerModel() {
		return customerModel;
	}

	/**
	 * Sets the customer view model associated with this order.
	 * 
	 * @param customer the customer view model to set
	 */
	public void setCustomerModel(CustomerViewModel customer) {
		this.customerModel = customer;
	}

	/**
	 * Gets the underlying domain model for this order.
	 * 
	 * @return the order domain model
	 */
	public OrderModel getDomainModel() {
		return domainModel;
	}

	/**
	 * Sets the underlying domain model for this order.
	 * 
	 * @param domainModel the order domain model to set
	 */
	public void setDomainModel(OrderModel domainModel) {
		this.domainModel = domainModel;
	}

	/**
	 * Gets the list of order item view models in this order.
	 * 
	 * @return the list of order item view models
	 */
	public List<OrderItemViewModel> getItems() {
		return items;
	}

	/**
	 * Sets the list of order item view models in this order.
	 * 
	 * @param items the list of order item view models to set
	 */
	public void setItems(List<OrderItemViewModel> items) {
		this.items = items;
	}

	/**
	 * Gets the total amount for the order, calculated from order items.
	 * 
	 * @return the total amount
	 */
	public float getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the total amount for the order.
	 * 
	 * @param totalAmount the total amount to set
	 */
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
}
