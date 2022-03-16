package services;

import models.*;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    void createEmployee(Employee employeeCreate);

    Employee getEmployee(int employeeIdUpdate);

    void updateEmployee(Employee employeeUpdate);

    void deleteEmployee(int idEmployeeDelete);

    List<Employee> searchEmployeeByName(String employeeNameSearch);

    List<Employee> sortEmployeeById();

    List<Employee> sortEmployeeByName();

    List<Employee> sortEmployeeByBirthday();

    List<Employee> sortEmployeeBySalary();
}
