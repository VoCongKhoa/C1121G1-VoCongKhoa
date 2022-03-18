package repositories;

import models.*;

import java.util.List;

public interface IContractRepository {
    List<Contract> getAllContract();

    List<Service> getAllService();

    Employee getEmployee(int employeeId);

    Customer getCustomer(int customerId);

    Service getService(int serviceId);

    void createContract(Contract contractCreate);

    List<ContractDetail> getAllContractDetail();

    Contract getContract(int contractId);
}
