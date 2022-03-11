package repositories.impl;

import models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    void create(Product product);
    void update(Integer id, Product product);
    void delete(Integer id);
    Product getDetail(Integer id);
    List<Product> searchByName(String name);
    Product searchById(Integer id);
}
