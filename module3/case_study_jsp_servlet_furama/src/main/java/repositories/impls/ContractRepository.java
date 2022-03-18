package repositories.impls;

import models.*;
import repositories.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    IServiceRepository iServiceRepository = new ServiceRepository();
    IContractRepository iContractRepository = new ContractRepository();
    IAttachServiceRepository iAttachServiceRepository  = new AttachServiceRepository();
    @Override
    public List<Contract> getAllContract() {
        List<Contract> contractList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection = null;
        Employee employee;
        Customer customer;
        Service service;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT contract_id, contract_start_date, " +
                    "contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id " +
                    "FROM contract;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                double contractDeposit = resultSet.getDouble("contract_deposit");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                employee = iEmployeeRepository.getEmployee(employeeId);
                int customerId = resultSet.getInt("customer_id");
                customer = iCustomerRepository.getCustomer(customerId);
                int serviceId = resultSet.getInt("service_id");
                service = iServiceRepository.getService(serviceId);
                contractList.add(new Contract(contractId, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney,
                        employee, customer, service));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractList;
    }

    @Override
    public List<Service> getAllService() {
        return iServiceRepository.getAllService();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return iEmployeeRepository.getEmployee(employeeId);
    }

    @Override
    public Customer getCustomer(int customerId) {
        return iCustomerRepository.getCustomer(customerId);
    }

    @Override
    public Service getService(int serviceId) {
        return iServiceRepository.getService(serviceId);
    }

    @Override
    public void createContract(Contract contractCreate) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contract(contract_id, " +
                    "contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, " +
                    "customer_id, service_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, contractCreate.getContractId());
            preparedStatement.setString(2, contractCreate.getContractStartDate());
            preparedStatement.setString(3, contractCreate.getContractEndDate());
            preparedStatement.setDouble(4, contractCreate.getContractDeposit());
            preparedStatement.setDouble(5, contractCreate.getContractTotalMoney());
            preparedStatement.setInt(6, contractCreate.getEmployee().getEmployeeId());
            preparedStatement.setInt(7, contractCreate.getCustomer().getCustomerId());
            preparedStatement.setInt(8, contractCreate.getService().getServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection = null;
        Contract contract;
        AttachService attachService;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT contract_detail_id, quantity, " +
                    "contract_id, attach_service_id FROM contract;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int quantity = resultSet.getInt("quantity");
                int contractId = resultSet.getInt("contract_id");
                contract = iContractRepository.getContract(contractId);
                int attachServiceId = resultSet.getInt("attach_service_id");
                attachService = iAttachServiceRepository.getAttachService(attachServiceId);
                contractDetailList.add(new ContractDetail(contractDetailId, quantity, contract, attachService));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractDetailList;
    }

    @Override
    public Contract getContract(int contractId) {
        Contract contract = null;
        Connection connection = null;
        Employee employee;
        Customer customer;
        Service service;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT contract_id, contract_start_date, " +
                    "contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id " +
                    "FROM contract WHERE contract_id = ?;");
            preparedStatement.setInt(1,contractId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractIdGetOne = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                double contractDeposit = resultSet.getDouble("contract_deposit");
                double contractTotalMoney = resultSet.getDouble("contract_total_money");
                int employeeId = resultSet.getInt("employee_id");
                employee = iEmployeeRepository.getEmployee(employeeId);
                int customerId = resultSet.getInt("customer_id");
                customer = iCustomerRepository.getCustomer(customerId);
                int serviceId = resultSet.getInt("service_id");
                service = iServiceRepository.getService(serviceId);
                contract = new Contract(contractIdGetOne, contractStartDate, contractEndDate, contractDeposit, contractTotalMoney,
                        employee, customer, service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contract;
    }
}
