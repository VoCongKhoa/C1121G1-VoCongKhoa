package services.impls;

import models.*;
import repositories.IContractRepository;
import repositories.impls.ContractRepository;
import services.IContractService;
import services.ICustomerService;
import services.IEmployeeService;
import services.IServiceService;

import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository iContractRepository = new ContractRepository();
//    private IEmployeeService iEmployeeService = new EmployeeService();
//    private ICustomerService iCustomerService = new CustomerService();
//    private IServiceService iServiceService = new ServiceService();
    @Override
    public List<Contract> getAllContract() {
        return iContractRepository.getAllContract();
    }

    @Override
    public List<Service> getAllService() {
        return iContractRepository.getAllService();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return iContractRepository.getEmployee(employeeId);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return iContractRepository.getCustomer(customerId);
    }

    @Override
    public Service getService(int serviceId) {
        return iContractRepository.getService(serviceId);
    }

    @Override
    public void createContract(Contract contractCreate) {
        iContractRepository.createContract(contractCreate);
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        return iContractRepository.getAllContractDetail();
    }
}
