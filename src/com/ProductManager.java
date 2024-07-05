package com;

import com.ecommerce.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private final List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
        // Initialize products
        this.products.add(new Product("PT001", "Laptop", 1200.99));
        this.products.add(new Product("PT002", "Smartphone", 800.01));
        this.products.add(new Product("PT003", "Headphones", 150.25));
        this.products.add(new Product("PT004", "Bag", 50.60));
        this.products.add(new Product("PT005", "External hard drive", 90.27));
        this.products.add(new Product("PT006", "Wireless mouse", 150.86));
        this.products.add(new Product("PT007", "External keyboard", 150.87));
        this.products.add(new Product("PT008", "Power supply", 150.32));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}