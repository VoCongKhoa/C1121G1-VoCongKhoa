package services;

import models.Product;
import repositories.ProductRepositoryImpl;
import repositories.impl.ProductRepository;
import services.impl.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public Product getDetail(Integer id) {
        return productRepository.getDetail(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public Product searchById(Integer id) {
        return productRepository.searchById(id);
    }
}
