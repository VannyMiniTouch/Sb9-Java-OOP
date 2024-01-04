package dao;

import database.StaticDatabase;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> selectAll() {
        return StaticDatabase.products;
    }

    @Override
    public Optional<Product> selectByCode(Integer code) {
        return StaticDatabase.products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst();
    }

    @Override
    public Product insert(Product product) {
        StaticDatabase.products.add(product);
        return product;
    }

    @Override
    public Product updateByCode(Product product) {
        StaticDatabase.products.stream()
                .peek(oldProduct -> {
                    if (oldProduct.getCode().equals(product.getCode())) {
                        oldProduct.setName(product.getName());
                        oldProduct.setPrice(product.getPrice());
                        oldProduct.setInStock(product.getInStock());
                    }
                }).forEach(data -> System.out.println(data));
        return product;
    }

    @Override
    public void deleteByCode(Integer code) {
        if (findProductCode(code)) {
            StaticDatabase.products.remove(selectByCode(code).get());
            System.out.println("Product has been deleted");
        } else {
            System.out.println("Product code is invalid");
        }
    }

    @Override
    public boolean findProductCode(Integer code) {
        Optional<Product> product = StaticDatabase.products.stream()
                .filter(p -> p.getCode().equals(code))
                .findFirst();
        return product.isPresent() ? true : false;
    }

    // @Override
    // public void deleteByCode(Integer code) {
    // StaticDatabase.products.stream()
    // .filter(product -> !product.getCode().equals(code))
    // .forEach(System.out::println);
    // }
}
