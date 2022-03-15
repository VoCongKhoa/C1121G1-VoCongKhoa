package repositories;

import models.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();

    void createCustomer(Customer customerCreate);
}
