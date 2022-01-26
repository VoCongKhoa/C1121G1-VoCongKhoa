package FuramaResort.services.impls;

import java.util.List;
import java.util.Scanner;

import FuramaResort.common.ReadAndWriteFile;
import FuramaResort.models.Employee;
import FuramaResort.services.EmployeeService;
import FuramaResort.utils.Validation;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    Validation validation = new Validation();
    static List<String> degreeList = new ArrayList<>();
    static List<String> roleList = new ArrayList<>();
    static final String EMPLOYEE_PATH_FILE = "src/FuramaResort/data/employee.csv";
    static final String ROLE_PATH_FILE = "src/FuramaResort/data/roleList.csv";
    static final String DEGREE_PATH_FILE = "src/FuramaResort/data/degreeList.csv";

    @Override
    public void displayEmployee() {
        employeeList = readCSVFileToEmployeeList(EMPLOYEE_PATH_FILE);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
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
                    degreeList = ReadAndWriteFile.readCSVFileToStringList(DEGREE_PATH_FILE);
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
                    roleList = ReadAndWriteFile.readCSVFileToStringList(ROLE_PATH_FILE);
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

        System.out.print("Add new salary of employee (Double number): ");
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

        Employee newEmployee = new Employee(newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newEmployeeDegree, newEmployeeRole, newEmployeeSalary);
        List<String> newEmployeeList = new ArrayList<>();
        newEmployeeList.add(newEmployee.toStringToCSVFile());
        ReadAndWriteFile.writeStringListIntoCSVFile(EMPLOYEE_PATH_FILE, newEmployeeList, true);
        System.out.println("Add new employee successfully!!!");
    }

    @Override
    public void editEmployee() {
        Scanner sc = new Scanner(System.in);
        employeeList = readCSVFileToEmployeeList(EMPLOYEE_PATH_FILE);
        System.out.print("Input id of employee you wanna edit: ");
        int editIdEmployeeChoice = Integer.parseInt(sc.nextLine());
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == editIdEmployeeChoice) {
                boolean employeeFlag = false;
                do {
                    System.out.println("List of employee property:\n" +
                            "1.Edit name\n" +
                            "2.Edit date of birth\n" +
                            "3.Edit gender\n" +
                            "4.Edit identification number\n" +
                            "5.Edit phone number\n" +
                            "6.Edit email\n" +
                            "7.Edit employee degree\n" +
                            "8.Edit employee role\n" +
                            "9.Edit employee salary\n" +
                            "10.Return employee management menu\n");
                    System.out.print("Input property you wanna edit: ");
                    int editPropertyEmployeeChoice = Integer.parseInt(sc.nextLine());
                    switch (editPropertyEmployeeChoice) {
                        case 1:
                            System.out.print("Input your new name: ");
                            while (true) {
                                String editName = sc.nextLine();
                                if (validation.validateName(editName)) {
                                    employee.setName(editName);
                                    writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee name successfully!!!");
                            break;
                        case 2:
                            System.out.print("Input your new date of birth: ");
                            employee.setDateOfBirth(sc.nextLine());
                            System.out.println("Edit employee DoB successfully!!!");
                            break;
                        case 3:
                            System.out.print("Input your new gender: ");
                            while (true) {
                                String editGender = sc.nextLine();
                                if (validation.validateGender(editGender)) {
                                    employee.setGender(editGender);
                                    writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee gender successfully!!!");
                            break;
                        case 4:
                            System.out.print("Input your new identification number: ");
                            while (true) {
                                String editIdNumber = sc.nextLine();
                                if (validation.validateIDNumber(editIdNumber)) {
                                    employee.setIDNumber(editIdNumber);
                                    writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee identification number successfully!!!");
                            break;
                        case 5:
                            System.out.print("Input your new phone number: ");
                            while (true) {
                                String editPhoneNumber = sc.nextLine();
                                if (validation.validatePhoneNumber(editPhoneNumber)) {
                                    employee.setPhoneNumber(editPhoneNumber);
                                    writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee phone number successfully!!!");
                            break;
                        case 6:
                            System.out.print("Input your new email: ");
                            while (true) {
                                String editEmail = sc.nextLine();
                                if (validation.validateEmail(editEmail)) {
                                    employee.setEmail(editEmail);
                                    writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit employee email successfully!!!");
                            break;
                        case 7:
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
                                        degreeList = ReadAndWriteFile.readCSVFileToStringList(DEGREE_PATH_FILE);
                                        String editEmployeeDegree = degreeList.get(editEmployeeDegreeChoice - 1);
                                        employee.setEmployeeDegree(editEmployeeDegree);
                                        writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

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
                        case 8:
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
                                        roleList = ReadAndWriteFile.readCSVFileToStringList(ROLE_PATH_FILE);
                                        String newEmployeeRole = roleList.get(newEmployeeRoleChoice - 1);
                                        employee.setEmployeeRole(newEmployeeRole);
                                        writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

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
                        case 9:
                            System.out.print("Input your new salary: ");
                            while (true) {
                                try {
                                    double newEmployeeSalary = Double.parseDouble(sc.nextLine());
                                    if ((newEmployeeSalary) > 0) {
                                        employee.setEmployeeSalary(newEmployeeSalary);
                                        writeEmployeeListIntoCSVFile(EMPLOYEE_PATH_FILE, employeeList, false);

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
                        case 10:
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

    public static List<Employee> readCSVFileToEmployeeList(String pathFile) {
        List<Employee> employeeListFromReadCSV = new ArrayList<>();
        List<String> lineList = ReadAndWriteFile.readCSVFileToStringList(pathFile);
        String[] lineSplitList;
        Employee.setNumberOfEmployee(0);
        for (String line : lineList) {
            lineSplitList = line.split(",");
            employeeListFromReadCSV.add(new Employee(lineSplitList[1], lineSplitList[2], lineSplitList[3], lineSplitList[4],
                    lineSplitList[5], lineSplitList[6], lineSplitList[7], lineSplitList[8], Double.parseDouble(lineSplitList[9])));
        }
        return employeeListFromReadCSV;
    }

    public static void writeEmployeeListIntoCSVFile(String pathFile, List<Employee> employeeList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.toStringToCSVFile());
        }
        ReadAndWriteFile.writeStringListIntoCSVFile(pathFile, stringList, append);
    }
}
