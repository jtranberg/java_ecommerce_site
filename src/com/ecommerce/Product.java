package com.ecommerce;
/**
 * this is the product constructor
 */
public class Product {
    private String productID;
    private String name;
    private double price;
    
  
/**
 * public info
 * @param productID id number for product
 * @param name of the user
 * @param price of the product
 */
    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }
/**
 * Get the product id number
 * @return product id number
 */
    public String getProductID() {
        return productID;
    }
/**
 * retrieve the users name
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * get the price of the item
 * @return price of item selected
 */
    public double getPrice() {
        return price;
    }
  
  
    @Override
    public String toString() {
        return  name +" Price: $" + price;
        
        
    }
}
