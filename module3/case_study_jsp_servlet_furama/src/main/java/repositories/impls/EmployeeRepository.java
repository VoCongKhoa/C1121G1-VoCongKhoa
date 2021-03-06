package repositories.impls;

import models.*;
import repositories.BaseRepository;
import repositories.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name, " +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, " +
                    "position.position_id, position.position_name, education_degree.education_degree_id," +
                    "education_degree.education_degree_name, division.division_id,division.division_name, employee.username " +
                    "FROM employee \n" +
                    "INNER JOIN position ON employee.position_id = position.position_id\n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username ORDER BY employee_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                String positionName = (resultSet.getString("position_name"));
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = (resultSet.getString("education_degree_name"));
                int divisionId = resultSet.getInt("division_id");
                String divisionName = (resultSet.getString("division_name"));
                String username = resultSet.getString("username");
                employeeList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, positionName, educationDegreeId,
                        educationDegreeName, divisionId, divisionName, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT position_id, position_name FROM position;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                positionList.add(new Position(positionId, positionName));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT education_degree_id, education_degree_name FROM education_degree;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(educationDegreeId, educationDegreeName));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }

    @Override
    public List<Division> getAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT division_id, division_name FROM division;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisionList.add(new Division(divisionId, divisionName));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

    @Override
    public void createEmployee(Employee employeeCreate) { //Co the can employee_id de edit va delete
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, " +
                    "employee_email, employee_address, position_id, education_degree_id, division_id)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
//            preparedStatement.setInt(1, employeeCreate.getEmployeeId());
            preparedStatement.setString(1, employeeCreate.getEmployeeName());
            preparedStatement.setString(2, employeeCreate.getEmployeeBirthday());
            preparedStatement.setString(3, employeeCreate.getEmployeeIdCard());
            preparedStatement.setDouble(4, employeeCreate.getEmployeeSalary());
            preparedStatement.setString(5, employeeCreate.getEmployeePhone());
            preparedStatement.setString(6, employeeCreate.getEmployeeEmail());
            preparedStatement.setString(7, employeeCreate.getEmployeeAddress());
            preparedStatement.setInt(8, employeeCreate.getPositionId());
            preparedStatement.setInt(9, employeeCreate.getEducationDegreeId());
            preparedStatement.setInt(10, employeeCreate.getDivisionId());
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
    public Employee getEmployee(int employeeIdUpdate) { //Chu y: getEmployee phai lay truong employee_id, de truyen ve servlet, de truyen sang trang employeeUpdate.jsp
        Employee employee = null;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name, " +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, " +
                    "employee_address, position_id, education_degree_id, division_id FROM employee WHERE employee_id = ?;");
            preparedStatement.setInt(1, employeeIdUpdate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employeeUpdate) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET employee_name = ?, " +
                    "employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, " +
                    "employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? " +
                    "WHERE employee_id = ?;");
            preparedStatement.setString(1, employeeUpdate.getEmployeeName());
            preparedStatement.setString(2, employeeUpdate.getEmployeeBirthday());
            preparedStatement.setString(3, employeeUpdate.getEmployeeIdCard());
            preparedStatement.setDouble(4, employeeUpdate.getEmployeeSalary());
            preparedStatement.setString(5, employeeUpdate.getEmployeePhone());
            preparedStatement.setString(6, employeeUpdate.getEmployeeEmail());
            preparedStatement.setString(7, employeeUpdate.getEmployeeAddress());
            preparedStatement.setInt(8, employeeUpdate.getPositionId());
            preparedStatement.setInt(9, employeeUpdate.getEducationDegreeId());
            preparedStatement.setInt(10, employeeUpdate.getDivisionId());
            preparedStatement.setInt(11, employeeUpdate.getEmployeeId());
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
    public void deleteEmployee(int idEmployeeDelete) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee_id = ?;");
            preparedStatement.setInt(1, idEmployeeDelete);
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
    public List<Employee> searchEmployeeByName(String employeeNameSearch) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name, " +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address," +
                    "employee.position_id, employee.education_degree_id, employee.division_id, employee.username \n" +
                    "FROM employee INNER JOIN position ON employee.position_id = position.position_id \n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username\n" +
                    "WHERE employee_name LIKE CONCAT(\"%\",?,\"%\")\n" +
                    "ORDER BY employee_id;");
            preparedStatement.setString(1, employeeNameSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username));
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
        return employeeList;
    }

    @Override
    public List<Employee> sortEmployeeById() {
        List<Employee> employeeSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name," +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, " +
                    "employee_address,employee.position_id, employee.education_degree_id, employee.division_id, " +
                    "employee.username\n" +
                    "FROM employee INNER JOIN position ON employee.position_id = position.position_id \n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username\n" +
                    "ORDER BY employee_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeSortedList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username));
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
        return employeeSortedList;
    }

    @Override
    public List<Employee> sortEmployeeByName() {
        List<Employee> employeeSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name," +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, " +
                    "employee_address,employee.position_id, employee.education_degree_id, employee.division_id, " +
                    "employee.username\n" +
                    "FROM employee INNER JOIN position ON employee.position_id = position.position_id \n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username\n" +
                    "ORDER BY employee_name;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeSortedList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username));
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
        return employeeSortedList;
    }

    @Override
    public List<Employee> sortEmployeeByBirthday() {
        List<Employee> employeeSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name," +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address," +
                    "employee.position_id, employee.education_degree_id, employee.division_id, employee.username\n" +
                    "FROM employee INNER JOIN position ON employee.position_id = position.position_id \n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username\n" +
                    "ORDER BY employee_birthday DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeSortedList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username));
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
        return employeeSortedList;
    }

    @Override
    public List<Employee> sortEmployeeBySalary() {
        List<Employee> employeeSortedList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT employee_id, employee_name," +
                    "employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address," +
                    "employee.position_id, employee.education_degree_id, employee.division_id, employee.username\n" +
                    "FROM employee INNER JOIN position ON employee.position_id = position.position_id \n" +
                    "INNER JOIN education_degree ON employee.education_degree_id = education_degree.education_degree_id\n" +
                    "INNER JOIN division ON employee.division_id = division.division_id\n" +
                    "LEFT JOIN user ON employee.username = user.username\n" +
                    "ORDER BY employee_salary;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeSortedList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username));
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
        return employeeSortedList;
    }
}
