package services;

import models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    void createCustomer(Customer customerCreate);
}
