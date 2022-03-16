package services.impls;

import models.Division;
import models.EducationDegree;
import models.Employee;
import models.Position;
import repositories.IEmployeeRepository;
import repositories.impls.EmployeeRepository;
import services.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepository.getAllEmployee();
    }

    @Override
    public List<Position> getAllPosition() {
        return iEmployeeRepository.getAllPosition();
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return iEmployeeRepository.getAllEducationDegree();
    }

    @Override
    public List<Division> getAllDivision() {
        return iEmployeeRepository.getAllDivision();
    }

    @Override
    public void createEmployee(Employee employeeCreate) {
        iEmployeeRepository.createEmployee(employeeCreate);
    }

    @Override
    public Employee getEmployee(int employeeIdUpdate) {
        return iEmployeeRepository.getEmployee(employeeIdUpdate);
    }

    @Override
    public void updateEmployee(Employee employeeUpdate) {
        iEmployeeRepository.updateEmployee(employeeUpdate);
    }
}
