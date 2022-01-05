package FuramaResort.models;


public class Employee extends Person {
    private int empId;
    private String empDegree;
    private String empRole;
    private double empSalary;

    public Employee() {
    }

    public Employee(int empId, String empDegree, String empRole, double empSalary) {
        this.empId = empId;
        this.empDegree = empDegree;
        this.empRole = empRole;
        this.empSalary = empSalary;
    }

    public Employee(String name, int age, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, int empId, String empDegree, String empRole, double empSalary) {
        super(name, age, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.empId = empId;
        this.empDegree = empDegree;
        this.empRole = empRole;
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpDegree() {
        return empDegree;
    }

    public void setEmpDegree(String empDegree) {
        this.empDegree = empDegree;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId = '" + empId + '\'' +
                ", name = " + getName()+
                ", dateOfBirth = " + getDateOfBirth()+
                ", gender = " + getGender()+
                ", idNumber = " + getIdNumber()+
                ", phoneNumber = " + getPhoneNumber()+
                ", email = " + getEmail()+
                ", empDegree = " + empDegree+
                ", empRole = " + empRole+
                ", empSalary = " + empSalary +
                '}';
    }
}
