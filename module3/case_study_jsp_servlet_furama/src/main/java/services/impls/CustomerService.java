package services.impls;

import models.Customer;
import repositories.ICustomerRepository;
import repositories.impls.CustomerRepository;
import services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAllCustomer() {
        return iCustomerRepository.getAllCustomer();
    }

    @Override
    public void createCustomer(Customer customerCreate) {
        iCustomerRepository.createCustomer(customerCreate);
    }
}
