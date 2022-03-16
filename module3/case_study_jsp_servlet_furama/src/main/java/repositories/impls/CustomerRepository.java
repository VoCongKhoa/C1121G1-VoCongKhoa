package repositories.impls;

import models.Customer;
import models.CustomerType;
import repositories.BaseRepository;
import repositories.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, " +
                    "customer_email, customer_address, customer.customer_type_id, customer_type_name " +
                    "FROM customer INNER JOIN customer_type " +
                    "ON customer.customer_type_id = customer_type.customer_type_id ORDER BY customer_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerList.add(new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId, customerTypeName));
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
        return customerList;
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_type_id, " +
                    "customer_type_name FROM customer_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(customerTypeId, customerTypeName));
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
        return customerTypeList;
    }

    @Override
    public void createCustomer(Customer customerCreate) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer(customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, " +
                    "customer_address, customer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, customerCreate.getCustomerCode());
            preparedStatement.setString(2, customerCreate.getCustomerName());
            preparedStatement.setString(3, customerCreate.getCustomerBirthday());
            preparedStatement.setInt(4, customerCreate.getCustomerGender());
            preparedStatement.setString(5, customerCreate.getCustomerIdCard());
            preparedStatement.setString(6, customerCreate.getCustomerPhone());
            preparedStatement.setString(7, customerCreate.getCustomerEmail());
            preparedStatement.setString(8, customerCreate.getCustomerAddress());
            preparedStatement.setInt(9, customerCreate.getCustomerTypeId());
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
    public void updateCustomer(Customer updateCustomer) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET customer_code = ?, " +
                    "customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, " +
                    "customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? " +
                    "WHERE customer_id = ?;");
            preparedStatement.setString(1, updateCustomer.getCustomerCode());
            preparedStatement.setString(2, updateCustomer.getCustomerName());
            preparedStatement.setString(3, updateCustomer.getCustomerBirthday());
            preparedStatement.setInt(4, updateCustomer.getCustomerGender());
            preparedStatement.setString(5, updateCustomer.getCustomerIdCard());
            preparedStatement.setString(6, updateCustomer.getCustomerPhone());
            preparedStatement.setString(7, updateCustomer.getCustomerEmail());
            preparedStatement.setString(8, updateCustomer.getCustomerAddress());
            preparedStatement.setInt(9, updateCustomer.getCustomerTypeId());
            preparedStatement.setInt(10, updateCustomer.getCustomerId());
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
    public Customer getCustomer(int customerIdUpdate) {
        Customer customer = null;
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, " +
                    "customer_email, customer_address, customer_type_id FROM customer WHERE customer_id = ?;");
            preparedStatement.setInt(1,customerIdUpdate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customer = new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId);
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
        return customer;
    }

    @Override
    public void deleteCustomer(int idCustomerDelete) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customer_id = ?;");
            preparedStatement.setInt(1, idCustomerDelete);
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
    public List<Customer> searchCustomerByName(String customerNameSearch) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, " +
                    "customer_address, customer_type_id FROM customer WHERE customer_name LIKE concat('%',?,'%');");
            preparedStatement.setString(1, customerNameSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
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
        return customerList;
    }

    @Override
    public List<Customer> sortCustomerById() {
        List<Customer> userSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, " +
                    "customer_email, customer_address, customer_type_id FROM customer ORDER BY customer_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                userSortedList.add(new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
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
        return userSortedList;
    }

    @Override
    public List<Customer> sortCustomerByName() {
        List<Customer> userSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, " +
                    "customer_email, customer_address, customer_type_id FROM customer ORDER BY customer_name;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                userSortedList.add(new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
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
        return userSortedList;
    }

    @Override
    public List<Customer> sortCustomerByBirthday() {
        List<Customer> userSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT customer_id, customer_code, " +
                    "customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, " +
                    "customer_email, customer_address, customer_type_id FROM customer ORDER BY customer_birthday DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String customerCode = resultSet.getString("customer_code");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                userSortedList.add(new Customer(customerId, customerCode, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
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
        return userSortedList;
    }
}
