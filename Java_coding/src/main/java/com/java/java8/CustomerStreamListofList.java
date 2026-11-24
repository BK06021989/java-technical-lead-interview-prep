package com.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerStreamListofList {

	static class Customer {
		private String name;
		private String mobNo;

		Customer(String name, String mobNo) {
			this.name = name;
			this.mobNo = mobNo;
		}

		public String getName() {
			return name;
		}

		public String getMobNo() {
			return mobNo;
		}
	}

	public static void main(String[] args) {
		List<List<List<Customer>>> listOfCustomer = Arrays.asList(
				Arrays.asList(Arrays.asList(new Customer("Amit", "9876543210"), new Customer("Bipin", "9123456780")),
						Arrays.asList(new Customer("Neha", "9988776655"))),
				Arrays.asList(Arrays.asList(new Customer("Ravi", "9000011111"))));

		List<String> customerDetails = listOfCustomer.stream().flatMap(level1 -> level1.stream())
				.flatMap(level2 -> level2.stream())
				.map(customer -> customer.getName() + " - " + customer.getMobNo())
				.collect(Collectors.toList());

		customerDetails.forEach(System.out::println);
	}
}