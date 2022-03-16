package controllers;

import models.*;
import services.ICustomerService;
import services.IEmployeeService;
import services.impls.CustomerService;
import services.impls.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                listAllEmployee(request, response);
                break;
            case "create":
                showEmployeeCreateForm(request, response);
                break;
            case "update":
                showUpdateEmployeeForm(request, response);
                break;
//            case "search":
//                searchCustomerByName(request, response);
//                break;
//            case "idSort":
//                sortById(request, response);
//                break;
//            case "nameSort":
//                sortByName(request, response);
//                break;
//            case "birthdaySort":
//                sortByBirthday(request, response);
//                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
        }
    }

    private void listAllEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
    }

    private void showEmployeeCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createEmployee.jsp");
        try {
            List<Position> employeePositionListCreate = iEmployeeService.getAllPosition();
            List<EducationDegree> employeeEducationDegreeListCreate = iEmployeeService.getAllEducationDegree();
            List<Division> employeeDivisionListCreate = iEmployeeService.getAllDivision();
            request.setAttribute("positionListCreate", employeePositionListCreate);
            request.setAttribute("educationDegreeListCreate", employeeEducationDegreeListCreate);
            request.setAttribute("divisionListCreate", employeeDivisionListCreate);
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeName = request.getParameter("employeeNameCreate");
        String employeeBirthday = request.getParameter("employeeBirthdayCreate");
        String employeeIdCard = request.getParameter("employeeIdCardCreate");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalaryCreate"));
        String employeePhone = request.getParameter("employeePhoneCreate");
        String employeeEmail = request.getParameter("employeeEmailCreate");
        String employeeAddress = request.getParameter("employeeAddressCreate");
        int positionId = Integer.parseInt(request.getParameter("positionIdCreate"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeIdCreate"));
        int divisionId = Integer.parseInt(request.getParameter("divisionIdCreate"));
        Employee employeeCreate = new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,
                employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId);
        iEmployeeService.createEmployee(employeeCreate);
        request.setAttribute("messageCreate", "Add new employee successfully!!!");
        request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
    }

    private void showUpdateEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeIdUpdate = Integer.parseInt(request.getParameter("id"));
        Employee employeeUpdate = iEmployeeService.getEmployee(employeeIdUpdate);
        List<Position> employeePositionListUpdate = iEmployeeService.getAllPosition();
        List<EducationDegree> employeeEducationDegreeListUpdate = iEmployeeService.getAllEducationDegree();
        List<Division> employeeDivisionListUpdate = iEmployeeService.getAllDivision();
        request.setAttribute("employee", employeeUpdate);
        request.setAttribute("employeePositionListUpdate", employeePositionListUpdate);
        request.setAttribute("employeeEducationDegreeListUpdate", employeeEducationDegreeListUpdate);
        request.setAttribute("employeeDivisionListUpdate", employeeDivisionListUpdate);
        request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeIdUpdate = Integer.parseInt(request.getParameter("id"));
        Employee employeeUpdate = iEmployeeService.getEmployee(employeeIdUpdate);
        employeeUpdate.setEmployeeName(request.getParameter("employeeNameUpdate"));
        employeeUpdate.setEmployeeBirthday(request.getParameter("employeeBirthdayUpdate"));
        employeeUpdate.setEmployeeIdCard(request.getParameter("employeeIdCardUpdate"));
        employeeUpdate.setEmployeeSalary(Double.parseDouble(request.getParameter("employeeSalaryUpdate")));
        employeeUpdate.setEmployeePhone(request.getParameter("employeePhoneUpdate"));
        employeeUpdate.setEmployeeEmail(request.getParameter("employeeEmailUpdate"));
        employeeUpdate.setEmployeeAddress(request.getParameter("employeeAddressUpdate"));
        employeeUpdate.setPositionId(Integer.parseInt(request.getParameter("employeePositionId")));
        employeeUpdate.setEducationDegreeId(Integer.parseInt(request.getParameter("employeeEducationDegreeId")));
        employeeUpdate.setDivisionId(Integer.parseInt(request.getParameter("employeeDivisionId")));
        iEmployeeService.updateEmployee(employeeUpdate);
        request.setAttribute("messageUpdate", "Update new employee successfully!!!");
        request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
    }
}
