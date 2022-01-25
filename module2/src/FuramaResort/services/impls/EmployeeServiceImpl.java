package FuramaResort.services.impls;

import java.util.List;
import java.util.Scanner;
import FuramaResort.models.Employee;
import FuramaResort.services.EmployeeService;
import FuramaResort.utils.Validation;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    Validation validation = new Validation();
    static List<String> degreeList = new ArrayList<>();
    static List<String> roleList = new ArrayList<>();

    static {
        degreeList.add("High school");
        degreeList.add("Associate");
        degreeList.add("University");
        degreeList.add("Master");

        roleList.add("Receptionist");
        roleList.add("Waiter");
        roleList.add("Expert");
        roleList.add("Supervisor");
        roleList.add("Manager");
        roleList.add("Director");
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
        System.out.println("Employee list:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add new id of employee (Ex: 11,222,...): ");//Chỉ số nguyên lớn hơn 0
        int newEmployeeId;
        while (true) {
            try {
                if ((newEmployeeId = Integer.parseInt(sc.nextLine())) > 0) {
                    break;
                } else {
                    System.out.println("Employee id have to be positive number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.print("Add new name of employee (Ex: Alex,khoa123,...): ");//Bắt buộc bắt đầu bằng chữ
        String newName;
        while (true) {
            if (validation.validateName(newName = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new DoB of employee: ");//Dùng regrex DoB
        String newDateOfBirth = sc.nextLine();

        System.out.print("Add new gender of employee (Only Male or Female): ");//Chỉ Male hoặc Female
        String newGender;
        while (true) {
            if (validation.validateGender(newGender = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new ID number of employee (12 digits): "); //12 số nguyên
        String newIdNumber;
        while (true) {
            if (validation.validateIDNumber(newIdNumber = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new phone number of employee (Ex: (+86) 905472592,...): ");//(+84) 905472592
        String newPhoneNumber;
        while (true) {
            if (validation.validatePhoneNumber(newPhoneNumber = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new email of employee (Ex: youandme8668@gmail.com.vn): ");
        String newEmail;
        while (true) {
            if (validation.validateEmail(newEmail = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.println("Employee degree:");
        System.out.println("1. High school");
        System.out.println("2. Associate");
        System.out.println("3. University");
        System.out.println("4. Master");
        System.out.print("Choice the employee degree: ");
        int newEmployeeDegreeChoice;
        String newEmployeeDegree;
        while (true) {
            try {
                newEmployeeDegreeChoice = Integer.parseInt(sc.nextLine());
                if (newEmployeeDegreeChoice > 0 && newEmployeeDegreeChoice < 5) {
                    newEmployeeDegree = degreeList.get(newEmployeeDegreeChoice - 1);
                    break;
                } else {
                    System.out.println("Wrong number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.println("Employee role:");
        System.out.println("1. Receptionist");
        System.out.println("2. Waiter");
        System.out.println("3. Expert");
        System.out.println("4. Supervisor");
        System.out.println("5. Manager");
        System.out.println("6. Director");
        System.out.print("Choice the employee role: ");
        int newEmployeeRoleChoice;
        String newEmployeeRole;
        while (true) {
            try {
                newEmployeeRoleChoice = Integer.parseInt(sc.nextLine());
                if (newEmployeeRoleChoice > 0 && newEmployeeRoleChoice < 7) {
                    newEmployeeRole = roleList.get(newEmployeeRoleChoice - 1);
                    break;
                } else {
                    System.out.println("Wrong number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.println("Add new salary of employee (Double number): ");
        double newEmployeeSalary;
        while (true) {
            try {
                if ((newEmployeeSalary = Double.parseDouble(sc.nextLine())) > 0) {
                    break;
                } else {
                    System.out.println("Employee id have to be positive number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        Employee newEmployee = new Employee(newEmployeeId, newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newEmployeeDegree, newEmployeeRole, newEmployeeSalary);
        employeeList.add(newEmployee);
        System.out.println("Add new employee successfully!!!");
    }

    @Override
    public void editEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id of employee you wanna edit:");
        int editIdEmployeeChoice = Integer.parseInt(sc.nextLine());
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == editIdEmployeeChoice) {
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
                    int editPropertyEmployeeChoice = Integer.parseInt(sc.nextLine());
                    switch (editPropertyEmployeeChoice) {
                        case 1:
                            System.out.print("Input your new employee id: ");
                            while (true) {
                                try {
                                    int editEmployeeId = Integer.parseInt(sc.nextLine());
                                    if (editEmployeeId > 0) {
                                        employee.setEmployeeId(editEmployeeId);
                                        break;
                                    } else {
                                        System.out.println("Employee id have to be positive number!!! Input again!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number!!! Input again!");
                                } catch (Exception e) {
                                    System.out.println("Wrong format !!! Input again!");
                                }
                            }
                            System.out.println("Edit employee id successfully!!!");
                            break;
                        case 2:
                            System.out.print("Input your new name: ");
                            while (true) {
                                String editName = sc.nextLine();
                                if (validation.validateName(editName)) {
                                    employee.setName(editName);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee name successfully!!!");
                            break;
                        case 3:
                            System.out.print("Input your new date of birth: ");
                            employee.setDateOfBirth(sc.nextLine());
                            System.out.println("Edit employee DoB successfully!!!");
                            break;
                        case 4:
                            System.out.print("Input your new gender: ");
                            while (true) {
                                String editGender = sc.nextLine();
                                if (validation.validateGender(editGender)) {
                                    employee.setGender(editGender);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee gender successfully!!!");
                            break;
                        case 5:
                            System.out.print("Input your new identification number: ");
                            while (true) {
                                String editIdNumber = sc.nextLine();
                                if (validation.validateIDNumber(editIdNumber)) {
                                    employee.setIDNumber(editIdNumber);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee identification number successfully!!!");
                            break;
                        case 6:
                            System.out.print("Input your new phone number: ");
                            while (true) {
                                String editPhoneNumber = sc.nextLine();
                                if (validation.validatePhoneNumber(editPhoneNumber)) {
                                    employee.setPhoneNumber(editPhoneNumber);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee phone number successfully!!!");
                            break;
                        case 7:
                            System.out.print("Input your new email: ");
                            while (true) {
                                String editEmail = sc.nextLine();
                                if (validation.validateEmail(editEmail)) {
                                    employee.setEmail(editEmail);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee email successfully!!!");
                            break;
                        case 8:
                            System.out.println("Employee degree:");
                            System.out.println("1. High school");
                            System.out.println("2. Associate");
                            System.out.println("3. University");
                            System.out.println("4. Master");
                            System.out.print("Choice the edit employee degree: ");
                            while (true) {
                                try {
                                    int editEmployeeDegreeChoice = Integer.parseInt(sc.nextLine());
                                    if (editEmployeeDegreeChoice > 0 && editEmployeeDegreeChoice < 5) {
                                        String editEmployeeDegree = degreeList.get(editEmployeeDegreeChoice - 1);
                                        employee.setEmployeeDegree(editEmployeeDegree);
                                        break;
                                    } else {
                                        System.out.println("Wrong number!!! Input again!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number!!! Input again!");
                                } catch (Exception e) {
                                    System.out.println("Wrong format !!! Input again!");
                                }
                            }
                            System.out.println("Edit employee degree successfully!!!");
                            break;
                        case 9:
                            System.out.println("Employee role:");
                            System.out.println("1. Receptionist");
                            System.out.println("2. Waiter");
                            System.out.println("3. Expert");
                            System.out.println("4. Supervisor");
                            System.out.println("5. Manager");
                            System.out.println("6. Director");
                            System.out.print("Choice the edit employee role: ");
                            while (true) {
                                try {
                                    int newEmployeeRoleChoice = Integer.parseInt(sc.nextLine());
                                    if (newEmployeeRoleChoice > 0 && newEmployeeRoleChoice < 7) {
                                        String newEmployeeRole = roleList.get(newEmployeeRoleChoice - 1);
                                        employee.setEmployeeRole(newEmployeeRole);
                                        break;
                                    } else {
                                        System.out.println("Wrong number!!! Input again!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number!!! Input again!");
                                } catch (Exception e) {
                                    System.out.println("Wrong format !!! Input again!");
                                }
                            }
                            System.out.println("Edit employee role successfully!!!");
                            break;
                        case 10:
                            System.out.print("Input your new salary: ");
                            while (true) {
                                try {
                                    double newEmployeeSalary = Double.parseDouble(sc.nextLine());
                                    if ((newEmployeeSalary) > 0) {
                                        employee.setEmployeeSalary(newEmployeeSalary);
                                        break;
                                    } else {
                                        System.out.println("Employee id have to be positive number!!! Input again!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number!!! Input again!");
                                } catch (Exception e) {
                                    System.out.println("Wrong format !!! Input again!");
                                }
                            }
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
