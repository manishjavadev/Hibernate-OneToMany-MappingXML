package com.manish.javadev.model;

import java.util.Date;

public class Order {
	private int orderId;
	private int totalQty;
	private Double totalCost;
	private Date orderDate;
	private String status;
	private Customer customer;
	public Order(){
		
	}
	public Order(int totalQty, Double totalCost, Date orderDate, String status) {
		super();
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
