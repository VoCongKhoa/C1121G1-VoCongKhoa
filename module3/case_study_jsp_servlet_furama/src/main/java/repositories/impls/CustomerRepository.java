package repositories.impls;

import models.Customer;
import repositories.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_management_system_database?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM furama_management_system_database.customer;";
    private final String INSERT_CUSTOMER_SQL = "INSERT INTO customer(customer_name, customer_birthday, " +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(customerId, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customerCreate) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1,customerCreate.getCustomerName());
            preparedStatement.setString(2,customerCreate.getCustomerBirthday());
            preparedStatement.setInt(3,customerCreate.getCustomerGender());
            preparedStatement.setString(4,customerCreate.getCustomerIdCard());
            preparedStatement.setString(5,customerCreate.getCustomerPhone());
            preparedStatement.setString(6,customerCreate.getCustomerEmail());
            preparedStatement.setString(7,customerCreate.getCustomerAddress());
            preparedStatement.setInt(8,customerCreate.getCustomerTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
