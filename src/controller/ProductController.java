package controller;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;
import view.ProductView;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductDao productDao;

    public ProductController() {
        productDao = new ProductDaoImpl();
    }

    public void listProducts() {
        List<Product> products = productDao.selectAll();
        ProductView.viewProductList(products);
    }

    public void listProductByCode(Integer code) {
        // Optional<Product> product = productDao.selectByCode(code);

        if (productDao.findProductCode(code)) {
            ProductView.viewProductByID(productDao.selectByCode(code).get());
        } else {
            System.out.println("Product code is invalid");
        }
    }

    public void insertProduct(Product product) {
        Optional<Product> findProduct = productDao.selectByCode(product.getCode());
        if (findProduct.isPresent()) {
            System.out.println("Product code already existing");
        } else {
            ProductView.viewInsertProduct(productDao.insert(product));
        }
    }

    public void updateProduct(Product product) {
        ProductView.updateProduct(productDao.updateByCode(product));
    }

    public void deleteProduct(Integer code) {
        productDao.deleteByCode(code);
    }

    public boolean checkProductCode(Integer code) {
        return productDao.findProductCode(code);
    }

}
