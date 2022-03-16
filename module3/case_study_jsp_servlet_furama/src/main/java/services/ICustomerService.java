package services;

import models.Customer;
import models.CustomerType;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    void createCustomer(Customer customerCreate);

    List<CustomerType> getAllCustomerType();

    void updateCustomer(Customer customerUpdate);

    Customer getCustomer(int customerIdUpdate);

    void deleteCustomer(int idCustomerDelete);

    List<Customer> searchCustomerByName(String customerNameSearch);

    List<Customer> sortCustomerById();

    List<Customer> sortCustomerByName();

    List<Customer> sortCustomerByBirthday();

}
