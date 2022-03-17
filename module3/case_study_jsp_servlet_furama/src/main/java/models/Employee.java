package models;

public class Employee {
    //employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email,
    //employee_address, position_id, position_name, education_degree_id, education_degree_name, division_id, username,password
    private int employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private int positionId;
    private String positionName;
    private int educationDegreeId;
    private String educationDegreeName;
    private int divisionId;
    private String divisionName;
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary,
                    String employeePhone, String employeeEmail, String employeeAddress, int positionId, String positionName,
                    int educationDegreeId, String educationDegreeName, int divisionId, String divisionName, String username,
                    String password) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.positionName = positionName;
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.username = username;
        this.password = password;
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary,
                    String employeePhone, String employeeEmail, String employeeAddress, int positionId,
                    int educationDegreeId, int divisionId, String username) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary,
                    String employeePhone, String employeeEmail, String employeeAddress, int positionId,
                    int educationDegreeId, int divisionId) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                    double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,
                    int positionId, int educationDegreeId, int divisionId, String username) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                    double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,
                    int positionId, int educationDegreeId, int divisionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                    double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,
                    int positionId, String positionName, int educationDegreeId, String educationDegreeName,
                    int divisionId, String divisionName, String username) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.positionName = positionName;
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.username = username;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBirthday='" + employeeBirthday + '\'' +
                ", employeeIdCard='" + employeeIdCard + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", educationDegreeId=" + educationDegreeId +
                ", educationDegreeName='" + educationDegreeName + '\'' +
                ", divisionId=" + divisionId +
                ", divisionName='" + divisionName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
