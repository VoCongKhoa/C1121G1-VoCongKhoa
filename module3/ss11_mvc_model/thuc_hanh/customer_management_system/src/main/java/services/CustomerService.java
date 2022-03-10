package services;

import models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void create(Customer customer);
    Customer findById(int id);
    void edit(int id, Customer customer);
    void remove(int id);
}
