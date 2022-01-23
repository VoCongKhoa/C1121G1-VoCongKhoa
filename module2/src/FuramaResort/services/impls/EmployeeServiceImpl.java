package FuramaResort.services.impls;

import java.util.List;
import java.util.Scanner;
import FuramaResort.models.Employee;
import FuramaResort.services.EmployeeService;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();

    static {
        Employee employee1 = new Employee(1, "Khoa", "22/08/1993", "male", "123",
                "0905472592", "youandme8668@gmail.com", "ĐH", "junior", 20);
        Employee employee2 = new Employee(2, "Su", "05/07/1996", "famale", "456",
                "0905111111", "youandme1@gmail.com", "ĐH", "junior", 10);
        Employee employee3 = new Employee(3, "abc", "01/01/1993", "male", "789",
                "0905111111", "youandme2@gmail.com", "ĐH", "junior", 50);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    @Override
    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new id of employee: ");
        int newEmpId = Integer.parseInt(sc.nextLine());
        System.out.println("Add new name of employee: ");
        String newName = sc.nextLine();
        System.out.println("Add new DoB of employee: ");
        String newDateOfBirth = sc.nextLine();
        System.out.println("Add new gender of employee: ");
        String newGender = sc.nextLine();
        System.out.println("Add new ID number of employee: ");
        String newIdNumber = sc.nextLine();
        System.out.println("Add new phone number of employee: ");
        String newPhoneNumber = sc.nextLine();
        System.out.println("Add new email of employee: ");
        String newEmail = sc.nextLine();
        System.out.println("Add new degree of employee: ");
        String newEmpDegree = sc.nextLine();
        System.out.println("Add new role of employee: ");
        String newEmpRole = sc.nextLine();
        System.out.println("Add new salary of employee: ");
        double newEmpSalary = Double.parseDouble(sc.nextLine());
        Employee newEmployee = new Employee(newEmpId, newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newEmpDegree, newEmpRole, newEmpSalary);
        employeeList.add(newEmployee);
        System.out.println("Add new employee successfully!!!");
    }

    @Override
    public void editEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id of employee you wanna edit:");
        int editIdEmpChoice = Integer.parseInt(sc.nextLine());
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == editIdEmpChoice) {
                boolean employeeFlag = false;
                do {
                    System.out.println("List of employee property:\n" +
                            "1.Edit employee id\n" +
                            "2.Edit name\n" +
                            "3.Edit date of birth\n" +
                            "4.Edit gender\n" +
                            "5.Edit identification number\n" +
                            "6.Edit phone number\n" +
                            "7.Edit email\n" +
                            "8.Edit employee degree\n" +
                            "9.Edit employee role\n" +
                            "10.Edit employee role\n" +
                            "11.Return employee management menu\n");
                    System.out.print("Input property you wanna edit: ");
                    int editPropertyEmpChoice = Integer.parseInt(sc.nextLine());
                    switch (editPropertyEmpChoice) {
                        case 1:
                            System.out.println("Input your new employee id:");
                            employee.setEmployeeId(Integer.parseInt(sc.nextLine()));
                            System.out.println("Edit employee id successfully!!!");
                            break;
                        case 2:
                            System.out.println("Input your new name:");
                            employee.setName(sc.nextLine());
                            System.out.println("Edit employee name successfully!!!");
                            break;
                        case 3:
                            System.out.println("Input your new date of birth:");
                            employee.setDateOfBirth(sc.nextLine());
                            System.out.println("Edit employee DoB successfully!!!");
                            break;
                        case 4:
                            System.out.println("Input your new gender:");
                            employee.setGender(sc.nextLine());
                            System.out.println("Edit employee gender successfully!!!");
                            break;
                        case 5:
                            System.out.println("Input your new identification number:");
                            employee.setIDNumber(sc.nextLine());
                            System.out.println("Edit employee identification number successfully!!!");
                            break;
                        case 6:
                            System.out.println("Input your new phone number:");
                            employee.setPhoneNumber(sc.nextLine());
                            System.out.println("Edit employee phone number successfully!!!");
                            break;
                        case 7:
                            System.out.println("Input your new email:");
                            employee.setEmail(sc.nextLine());
                            System.out.println("Edit employee email successfully!!!");
                            break;
                        case 8:
                            System.out.println("Input your new employee degree:");
                            employee.setEmployeeDegree(sc.nextLine());
                            System.out.println("Edit employee degree successfully!!!");
                            break;
                        case 9:
                            System.out.println("Input your new employee role:");
                            employee.setEmployeeRole(sc.nextLine());
                            System.out.println("Edit employee role successfully!!!");
                            break;
                        case 10:
                            System.out.println("Input your new salary:");
                            employee.setEmployeeSalary(Double.parseDouble(sc.nextLine()));
                            System.out.println("Edit employee salary successfully!!!");
                            break;
                        case 11:
                            employeeFlag = true;
                            returnMainMenu();
                            break;
                        default:
                            System.out.println("Choice again!!!");
                    }
                } while (!employeeFlag);

            }
        }
    }

    @Override
    public void returnMainMenu() {
    }
}
