package com.java.java8;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Order> orders = List.of(
				new Order("ORD-1001", "CUST-501", "SHIPPED",
						List.of(new OrderItem(1L, "Wireless Mouse", 24.99, 2),
								new OrderItem(2L, "USB-C Cable", 9.50, 1))),
				new Order("ORD-1002", "CUST-502", "PROCESSING",
						List.of(new OrderItem(3L, "Mechanical Keyboard", 79.99, 1),
								new OrderItem(4L, "Desk Mat", 18.00, 1))),
				new Order("ORD-1003", "CUST-503", "DELIVERED", 
						List.of(new OrderItem(5L, "Notebook", 90.25, 3))));
		System.out.println("calculateTotalRevenue=>"+calculateTotalRevenue(orders));
		//System.out.println(groupOrdersByCustomer(orders));
		System.out.println("getTopSpentCustomers=>"+getTopSpentCustomers(orders, 2));
		
		Map<String, List<Order>> groupedOrders = groupOrdersByCustomer(orders);
		for (Map.Entry<String, List<Order>> entry : groupedOrders.entrySet()) {
		    System.out.println("Customer ID: " + entry.getKey());

		    for (Order order : entry.getValue()) {
		        System.out.println("  Order ID: " + order.getOrderId());
		        System.out.println("  Status: " + order.getStatus());
		        System.out.println("  Items:");

		        for (OrderItem item : order.getItems()) {
		            System.out.println("    Item ID: " + item.getId());
		            System.out.println("    Name: " + item.getName());
		            System.out.println("    Price: " + item.getPrice());
		            System.out.println("    Quantity: " + item.getQuantity());
		        }
		    }
		}
	}

	public static double calculateTotalRevenue(List<Order> orders) {
		return orders.stream().flatMap(order -> order.getItems().stream())
				.mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}

	public static Map<String, List<Order>> groupOrdersByCustomer(List<Order> orders) {
		return orders.stream().collect(Collectors.groupingBy(Order::getCustomerId));
	}

	public static List<String> getTopSpentCustomers(List<Order> orders, int n) {
		Map<String, Double> spendingByCustomer = orders.stream().flatMap(order -> order.getItems().stream().map(
				item -> new AbstractMap.SimpleEntry<>(order.getCustomerId(), item.getPrice() * item.getQuantity())))
				.collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue)));

		return spendingByCustomer.entrySet().stream()
				.sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder())
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(n).map(Map.Entry::getKey).collect(Collectors.toList());
	}
}
