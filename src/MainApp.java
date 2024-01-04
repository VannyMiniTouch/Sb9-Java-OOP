import controller.ProductController;
import database.StaticDatabase;
import model.Product;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductController productController = new ProductController();

        // Program starts up
        StaticDatabase.init();

        System.out.println("Welcome to Product Management");
        System.out.println("-----------------------------");
        System.out.println("1. List Product");
        System.out.println("2. List Product by Code");
        System.out.println("3. Insert New Product");
        System.out.println("4. Update Product by Code");
        System.out.println("5. Delete Product by Code");

        do {
            System.out.print("Enter option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.println("List Product");
                    productController.listProducts();
                }
                case 2 -> {
                    System.out.println("List Product By Code");
                    System.out.print("Please input product code: ");
                    Integer code = Integer.parseInt(scanner.nextLine());
                    productController.listProductByCode(code);
                }
                case 3 -> {
                    System.out.println("Insert New Product");
                    System.out.print("Please input Product code: ");
                    Integer productCode = Integer.parseInt(scanner.nextLine());

                    if (productController.checkProductCode(productCode)) {
                        System.out.println("The product code already existing");
                    } else {
                        System.out.print("Please input Product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Please input product price: ");
                        Double productPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Please input product in stock, 1 in stock, 0 out of stock: ");
                        boolean productStock = (Integer.parseInt(scanner.nextLine()) == 1);

                        Product product = Product.builder()
                                .code(productCode)
                                .name(productName)
                                .price(productPrice)
                                .inStock(productStock)
                                .build();

                        productController.insertProduct(product);
                    }
                }
                case 4 -> {
                    System.out.println("Update Product by Code");
                    System.out.print("Please input Product code: ");
                    Integer productCode = Integer.parseInt(scanner.nextLine());
                    if (productController.checkProductCode(productCode)) {
                        System.out.print("Please input Product name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Please input product price: ");
                        Double productPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Please input product in stock, 1 in stock, 0 out of stock: ");
                        boolean productStock = (Integer.parseInt(scanner.nextLine()) == 1);

                        Product product = Product.builder()
                                .code(productCode)
                                .name(productName)
                                .price(productPrice)
                                .inStock(productStock)
                                .build();

                        productController.updateProduct(product);
                    } else {
                        System.out.println("Product code not found!");
                    }
                }
                case 5 -> {
                    System.out.println("Delete Product by Code");
                    System.out.print("Please input product code to delete: ");
                    Integer code = Integer.parseInt(scanner.nextLine());
                    productController.deleteProduct(code);
                }
                case 6 -> {
                    System.out.println("Good bye..!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option..!");
            }
        } while (true);

    }
}
