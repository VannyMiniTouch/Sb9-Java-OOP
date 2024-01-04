package view;

import model.Product;

import java.util.List;

public class ProductView {
    public static void viewProductList(List<Product> products) {
        products.forEach(product -> {
            display(product);
        });
        System.out.println();
    }

    public static void viewProductByID(Product product) {
        System.out.println("View Product by ID");
        display(product);
        System.out.println();
    }

    public static void viewInsertProduct(Product product) {
        System.out.println("New Product has been inserted.");
        display(product);
        System.out.println();
    }

    public static void updateProduct(Product product) {
        System.out.println("\nProduct has been updated.");
        display(product);
        System.out.println();
    }

    // public static void viewDeleteProduct(Product product) {
    // System.out.println("\nProduct below has been deleted.");
    // display(product);
    // }

    public static void display(Product product) {
        System.out.println("-------------------");
        System.out.println("Code: " + product.getCode());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("InStock: " + product.getInStock());
        // System.out.println("-------------------");
    }

}
