package com.ecommerce;

import java.util.ArrayList;
import java.util.List;
/**
 * Customer class with ID,Name,shopping cart
 */
public class Customer {
    private String customerID;
    private String name;
    private List<Product> shoppingCart;
/**
 * public constructor info
 * @param customerID int eger for id
 * @param name of customer
 * 
 */
    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    // Getters and Setters
    /**
     * getters and setters
     * @return cartinfo
     */
    public String getCustomerID() { return customerID; }
    /**
     * get customer name
     * @return name
     */
    public String getName() { return name; }
    /**
     * get the users name for the cart
     * @param name
     * name of user
     */
    public void setName(String name) { this.name = name; } 
    /**
     * retrieve shopping cart info
     * @return value
     */
    public List<Product> getShoppingCart() { return shoppingCart; }

    /**
     *  Methods to manage shopping cart
     * @param product for sale
     */
    public void addProductToCart(Product product) {
        shoppingCart.add(product);
    }
/**
 * remove the last product function
 * @param product
 * product variable call
 */
    public void removeProductFromCart(Product product) {
        shoppingCart.remove(product);
    }
/**
 * calculate the total cost of order
 * @return total value of cart
 */
    public double calculateTotalCost() {
        return shoppingCart.stream().mapToDouble(Product::getPrice).sum();
    }
/**
 * place the order button
 */
    public void placeOrder() {
        System.out.println("Order placed for customer: " + name);
        shoppingCart.clear(); // Clear the cart after placing the order
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name;
    }
}
