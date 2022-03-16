package repositories;

import models.*;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAllEmployee();

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    void createEmployee(Employee employeeCreate);

    Employee getEmployee(int employeeIdUpdate);

    void updateEmployee(Employee employeeUpdate);
}
