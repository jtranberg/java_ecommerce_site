package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

/**
 * This is the class for the Order portion
 */
public class Order {
    private String orderID;
    private Customer customer;
    /**
     * list of products
     */
    private List<Product> products;

    /**
     * function to place order
     * @param orderID number of order
     * @param customer name
     * @param products in cart
     */
    public Order(String orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
    }

    /**
     * Function to generate the order summary
     * @return order info
     */
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID).append("\n");
        summary.append("Customer: ").append(customer).append("\n");
        summary.append("Products:\n");
        for (Product product : products) {
            summary.append("Product ID: ").append(product.getProductID()).append(", ");
            summary.append("Name: ").append(product.getName()).append(", ");
            summary.append("Price: ").append(product.getPrice()).append("\n");
        }
        return summary.toString();
    }
}
