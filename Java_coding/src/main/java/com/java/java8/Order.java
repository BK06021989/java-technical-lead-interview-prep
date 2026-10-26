package com.java.java8;

import java.util.List;

public class Order {
	private String orderId;
	private String customerId;
	private String status;

	private List<OrderItem> items;

	public Order(String orderId, String customerId, String status, List<OrderItem> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.status = status;
		this.items = items;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	// TODO: Candidate must add necessary boilerplate constructors, getters, setters
}
