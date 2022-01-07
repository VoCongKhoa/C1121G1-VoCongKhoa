package FuramaResort.services;

import java.util.Scanner;
import FuramaResort.models.Employee;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

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
    public void displayEmp() {
        System.out.println(employeeList);
    }

    @Override
    public void addEmp() {
        System.out.println("Add new id of employee: ");
        int newEmpId = sc.nextInt();
        sc.nextLine();
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
        double newEmpSalary = sc.nextDouble();
        Employee newEmployee = new Employee(newEmpId, newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newEmpDegree, newEmpRole, newEmpSalary);
        employeeList.add(newEmployee);
    }

    @Override
    public void editEmp() {
        System.out.println("Input id of employee you wanna edit:");
        int editIdEmpChoice = sc.nextInt();
        for (Employee employee : employeeList) {
            if (employee.getEmpId() == editIdEmpChoice) {
                System.out.println("Input property you wanna edit:\n" +
                        "1.Edit employee id\n" +
                        "2.Edit name\n" +
                        "3.Edit date of birth\n" +
                        "4.Edit gender\n" +
                        "5.Edit identification number\n" +
                        "6.Edit phone number\n" +
                        "7.Edit email\n" +
                        "8.Edit employee degree\n" +
                        "9.Edit employee role\n" +
                        "10.Edit employee salary\n");
                int editPropertyEmpChoice = sc.nextInt();
                sc.nextLine();
                switch (editPropertyEmpChoice) {
                    case 1:
                        System.out.println("Input your new employee id:");
                        employee.setEmpId(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Input your new name:");
                        employee.setName(sc.nextLine());
                        sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Input your new date of birth:");
                        employee.setDateOfBirth(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Input your new gender:");
                        employee.setGender(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Input your new identification number:");
                        employee.setIdNumber(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Input your new phone number:");
                        employee.setPhoneNumber(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Input your new email:");
                        employee.setEmail(sc.nextLine());
                        break;
                    case 8:
                        System.out.println("Input your new employee id:");
                        employee.setEmpId(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 9:
                        System.out.println("Input your new employee degree:");
                        employee.setEmpDegree(sc.nextLine());
                        break;
                    case 10:
                        System.out.println("Input your new employee role:");
                        employee.setEmpRole(sc.nextLine());
                        break;
                    case 11:
                        System.out.println("Input your new salary:");
                        employee.setEmpSalary(sc.nextDouble());
                        break;
                }
            }
        }
    }

    @Override
    public void returnMainMenu() {
    }
}
