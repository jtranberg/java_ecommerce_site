package com;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * The external user input form
 */
public class UserInputFrame extends JFrame {
	/**
	 * This is the users name input fieldS
	 */
    private final JTextField nameField;
    /**
     * This displays the products in a dropdown menue
     */
    private final JComboBox<Product> productComboBox;
    /**
     * this is the add button function
     */
    private final JButton addButton;
    /**
     * This button removes thelast item added to the cart only.
     */
    private final JButton removeButton; 
    /**
     * This displays what is in the cart
     */
    private final JTextArea cartArea;
    /**
     * This is the check out button
     */
    private final JButton checkoutButton;
    /**
     * setting the variable of Customer
     */
    private final Customer customer;
    /**
     * This is the list of products
     */
    private final List<Product> products;
/**
 *  displays products available
 * @param products for sale
 */
    public UserInputFrame(List<Product> products) {
        this.products = products;
        this.customer = new Customer("C001", ""); 

        setTitle("E-Commerce System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2)); // Updated to 4 rows

        inputPanel.add(new JLabel("  Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("  Select Product:"));
        productComboBox = new JComboBox<>(products.toArray(Product[]::new));
        inputPanel.add(productComboBox);
        
        addButton = new JButton(" Add to Cart");
        inputPanel.add(addButton);
        
        // Remove button
        removeButton = new JButton(" Remove from Cart"); 
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);

        cartArea = new JTextArea();
        cartArea.setEditable(false);
        add(new JScrollPane(cartArea), BorderLayout.CENTER);

        checkoutButton = new JButton(" Checkout");
        add(checkoutButton, BorderLayout.SOUTH);

        addButton.addActionListener((ActionEvent e) -> {
            addProductToCart();
        });
         // Add action listener for remove button
        removeButton.addActionListener((ActionEvent e) -> {
            removeProductFromCart();
        });

        checkoutButton.addActionListener((ActionEvent e) -> {
            checkout();
        });
    }

    private void addProductToCart() {
        Product selectedProduct = (Product) productComboBox.getSelectedItem();
        if (selectedProduct != null) {
            customer.addProductToCart(selectedProduct);
            updateCartArea();
        }
    }

    private void removeProductFromCart() {
        Product selectedProduct = (Product) productComboBox.getSelectedItem();
        if (selectedProduct != null) {
            customer.removeProductFromCart(selectedProduct);
            updateCartArea();
        }
    }

    private void updateCartArea() {
        cartArea.setText("");
        for (Product product : customer.getShoppingCart()) {
            cartArea.append(product.toString() + "\n");
        }
    }

    private void checkout() {
        String name = nameField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        customer.setName(name);  // Set the customer's name

        // Calculate total cost
        double totalCost = customer.calculateTotalCost();

        // Create order
        List<Product> orderedProducts = customer.getShoppingCart();
        Order order = new Order("O001", customer, orderedProducts);

        // Display order summary and success message
        cartArea.setText(order.generateOrderSummary() + "\nTotal Cost: $" + totalCost);
        JOptionPane.showMessageDialog(this, "Order placed successfully!\nTotal Cost: $" + totalCost);
    }
}

