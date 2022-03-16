package services.impls;

import models.Customer;
import models.CustomerType;
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

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerRepository.getAllCustomerType();
    }

    @Override
    public void updateCustomer(Customer customerUpdate) {
        iCustomerRepository.updateCustomer(customerUpdate);
    }

    @Override
    public Customer getCustomer(int customerIdUpdate) {
        return iCustomerRepository.getCustomer(customerIdUpdate);
    }

    @Override
    public void deleteCustomer(int idCustomerDelete) {
        iCustomerRepository.deleteCustomer(idCustomerDelete);
    }

    @Override
    public List<Customer> searchCustomerByName(String customerNameSearch) {
        return iCustomerRepository.searchCustomerByName(customerNameSearch);
    }

    @Override
    public List<Customer> sortCustomerById() {
        return iCustomerRepository.sortCustomerById();
    }

    @Override
    public List<Customer> sortCustomerByName() {
        return iCustomerRepository.sortCustomerByName();
    }

    @Override
    public List<Customer> sortCustomerByBirthday() {
        return iCustomerRepository.sortCustomerByBirthday();
    }
}
