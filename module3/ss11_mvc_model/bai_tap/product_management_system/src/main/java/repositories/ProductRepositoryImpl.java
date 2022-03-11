package repositories;

import models.Product;
import repositories.impl.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1, new Product(1, "iPhone", 30000000.0, "Black", "Apple"));
        productMap.put(2, new Product(2, "Television", 7000000.0, "Grey", "Panasonic"));
        productMap.put(3, new Product(3, "Refrigerator", 10000000.0, "White", "Panasonic"));
        productMap.put(4, new Product(4, "Motorbike", 100000000.0, "Red-Black", "Honda"));
        productMap.put(5, new Product(5, "Fan", 300000.0, "Blue", "Asia"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }

    @Override
    public Product getDetail(Integer id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product: productMap.values()) {
            if (product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public Product searchById(Integer id) {
        return productMap.get(id);
    }
}
