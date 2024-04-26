package com.pluralsight;

import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class OnlineStore {
    private List<Product> products;
    private List<Product> cart;
    private Scanner scanner;

    public OnlineStore() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadProductsFromFile("src/main/resources/products.csv");
    }

    public void displayHomeScreen() {
        while (true) {
            System.out.println("Welcome to the Online Store");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
            }
            System.out.println();
        }
    }

    private void loadProductsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String sku = parts[0];
                    String name = parts[1];
                    try {
                        double price = Double.parseDouble(parts[2]);
                        String department = parts[3];
                        products.add(new Product(sku, name, price, department));
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException occurred while parsing price for line: " + line);
                    }
                } else {
                    System.out.println("Invalid data format for line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayProducts() {
        System.out.println("\nProducts: ");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
            }
            System.out.println((products.size() + 1) + ". Go back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= products.size()) {
                addToCart(products.get(choice - 1)); // Add this line to add the selected product to the cart
            } else if (choice == products.size() + 1) {
                // Go back option
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addToCart(Product selectedProduct) {
        cart.add(selectedProduct);
        System.out.println(selectedProduct.getName() + " added to cart.");
    }

    private void displayCart() {
        System.out.println("\nCart: ");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double total = 0;
            for (int i = 0; i < cart.size(); i++) {
                Product product = cart.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
                total += product.getPrice();
            }
            System.out.println("Total: $" + total);
            System.out.println("1. Check out");
            System.out.println("2. Remove Product");
            System.out.println("3. Go back to Home Screen");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    checkout(total);
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkout(double total) {
        System.out.println("Checking out...");
        cart.clear();
    }

    private void removeProduct() {
        System.out.print("Enter the number of the product to remove: ");
        int productNumber = scanner.nextInt();
        scanner.nextLine();
        if (productNumber >= 1 && productNumber <= cart.size()) {
            Product removedProduct = cart.remove(productNumber - 1);
            System.out.println(removedProduct.getName() + " removed from cart.");
        } else {
            System.out.println("Invalid product number. Please try again.");
        }
    }

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.displayHomeScreen();
    }
}
