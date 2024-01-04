package database;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class StaticDatabase {
    public static List<Product> products;

    public static void init() {
        products = new ArrayList<>();
        products.add(Product.builder()
                .code(1)
                .name("macBook M1 Pro")
                .price(1600.00)
                .inStock(true)
                .build());
        products.add(Product.builder()
                .code(2)
                .name("Dell Monitor")
                .price(160.00)
                .inStock(true)
                .build());
        products.add(Product.builder()
                .code(3)
                .name("Asus RJ4700")
                .price(960.00)
                .inStock(false)
                .build());
    }

}
