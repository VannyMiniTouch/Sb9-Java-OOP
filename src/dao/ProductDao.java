package dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> selectAll();

    Optional<Product> selectByCode(Integer code);

    Product insert(Product product);

    Product updateByCode(Product product);

    void deleteByCode(Integer code);

    boolean findProductCode(Integer code);

}
