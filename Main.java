package com;
// Welcome to my E-commerce sit with working shopping cart and data base.

//You can add items to cart, and remove last item from cart.
// Admin can add and remove items from database.
/**
* Welcome to my E-commerce sit with working shopping cart and data base.
*You can add items to cart, and remove last item from cart.
* Admin can add and remove items from database.
* 
* Files include java docs
* github repo @ https://github.com/jtranberg/java_ecommerce_site.git
*/
import com.ecommerce.Product;

/**
 * Main class for the e-commerce application.
 * 
 * @author Jay Tranberg
 * @version 03/07/2024
 */
public class Main {

    /**
     * Default constructor for the Main class.
     */
    public Main() {
        // Default constructor
    }

    /**
     * The main function to run the e-commerce application.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Create ProductManager and get products
        ProductManager productManager = new ProductManager();
        java.util.List<Product> products = productManager.getProducts();

        // Launch the User Input Frame
        UserInputFrame userInputFrame = new UserInputFrame(products);
        userInputFrame.setVisible(true);
    }
}
