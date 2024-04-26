Online Store
This project is a simple command-line online store application written in Java. It allows users to browse products, add them to a shopping cart, remove products from the cart, and checkout.

Usage
To use the application, follow these steps:
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files using javac *.java.
4. Run the application using java com.pluralsight.OnlineStore.

Features
Display Products: Users can view all available products, search for products by name, search for products within a specific price range, and search for products by department.
Display Cart: Users can view the products they have added to their cart, remove products from the cart, and proceed to checkout.
Checkout: Users can finalize their purchase by checking out, which clears the cart.

Screenshots
![Screenshot 2024-04-26 152909](https://github.com/Nyflyguyx200/online-store/assets/114933451/1d68edde-e029-48e2-b8d5-95d95685eb86)

![Screenshot 2024-04-26 153058](https://github.com/Nyflyguyx200/online-store/assets/114933451/4cdcebcb-d695-4dea-b427-e7f1c99977cf)

![Screenshot 2024-04-26 153302](https://github.com/Nyflyguyx200/online-store/assets/114933451/eb3438f5-3020-4af3-a810-612d99b8a78c)

![Screenshot 2024-04-26 153334](https://github.com/Nyflyguyx200/online-store/assets/114933451/6f0eeca1-f34b-46a5-bcb9-4673ddd22009)


Interesting Piece of Code
private void addToCart(Product selectedProduct) {
    cart.add(selectedProduct);
    System.out.println(selectedProduct.getName() + " added to cart.");
}

The addToCart() method efficiently encapsulates the logic for adding a product to the cart, enhancing code readability and maintainability. 
Its clear and descriptive name, coupled with encapsulation, promotes flexibility and reusability throughout the codebase, ensuring a streamlined approach to managing the cart functionality.




