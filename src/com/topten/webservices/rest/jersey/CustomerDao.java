package com.topten.webservices.rest.jersey;


import java.util.HashMap;
import java.util.Map;

public enum CustomerDao {
	instance;

	private Map<String, Customer> customers = new HashMap<String, Customer>();

	private CustomerDao() {

		// pumping-in some default data
		Customer customer = new Customer("1001", "hichem", "brahimi","+971551862886", "hichembrahimi@hotmail.fr", null);
		customers.put("1", customer);

		customer = new Customer("1002",  "paul", "pogba","+971551862886", "paulpogba@hotmail.fr", null);
		customers.put("2", customer);

		customer = new Customer("1003", "loic", "10ten","+971581805998", "loic@hotmail.fr", null);
		customers.put("3", customer);
	}

	public Map<String, Customer> getCustomers() {
		return customers;
	}

}
