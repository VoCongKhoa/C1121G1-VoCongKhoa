package FuramaResort.models;


public class Employee extends Person {
    private int employeeId;
    private String employeeDegree;
    private String employeeRole;
    private double employeeSalary;

    public Employee() {
    }

    public Employee(int employeeId, String employeeDegree, String employeeRole, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeDegree = employeeDegree;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
    }

    public Employee(int employeeId, String name, String dateOfBirth , String gender, String idNumber,
                    String phoneNumber, String email, String employeeDegree, String employeeRole, double employeeSalary) {
        super(name, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.employeeId = employeeId;
        this.employeeDegree = employeeDegree;
        this.employeeRole = employeeRole;
        this.employeeSalary = employeeSalary;
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
                "employeeId = '" + employeeId + '\'' +
                ", name = " + getName() +
                ", dateOfBirth = " + getDateOfBirth() +
                ", gender = " + getGender() +
                ", idNumber = " + getIdNumber() +
                ", phoneNumber = " + getPhoneNumber() +
                ", email = " + getEmail() +
                ", employeeDegree = " + employeeDegree +
                ", employeeRole = " + employeeRole +
                ", employeeSalary = " + employeeSalary +
                '}';
    }
}
