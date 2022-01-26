package FuramaResort.models;


public class Employee extends Person {
    private static int numberOfEmployee; // Tự động tăng Employee id
    private int employeeId;
    private String employeeDegree;
    private String employeeRole;
    private double employeeSalary;

    public Employee() {
    }

    public Employee(String employeeDegree, String employeeRole, double employeeSalary) {
        this.employeeId = this.numberOfEmployee++ + 1;
        this.employeeDegree = employeeDegree;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
    }

    public Employee(String name, String dateOfBirth, String gender, String IDNumber,
                    String phoneNumber, String email, String employeeDegree, String employeeRole, double employeeSalary) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.employeeId = this.numberOfEmployee++ + 1;
        this.employeeDegree = employeeDegree;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
    }

    public static int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public static void setNumberOfEmployee(int numberOfEmployee) {
        Employee.numberOfEmployee = numberOfEmployee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeDegree() {
        return employeeDegree;
    }

    public void setEmployeeDegree(String employeeDegree) {
        this.employeeDegree = employeeDegree;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId = '" + getEmployeeId() + '\'' +
                ", name = " + getName() +
                ", dateOfBirth = " + getDateOfBirth() +
                ", gender = " + getGender() +
                ", idNumber = " + getIDNumber() +
                ", phoneNumber = " + getPhoneNumber() +
                ", email = " + getEmail() +
                ", employeeDegree = " + employeeDegree +
                ", employeeRole = " + employeeRole +
                ", employeeSalary = " + employeeSalary +
                '}';
    }

    public String toStringToCSVFile() {
        return getEmployeeId() + "," + getName() + "," + getDateOfBirth() + "," + getGender() + "," + getIDNumber() + "," +
                getPhoneNumber() + "," + getEmail() + "," + employeeDegree + "," + employeeRole + "," + employeeSalary;
    }
}
