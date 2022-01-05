package demo.student_manager;

public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private String grade;
    private String school;
    private double mark;

    public Student() {
    }

    public Student(int id, String name, String dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Student(int id, String name, String dateOfBirth, String address, String grade, String school){
        this(id,name,dateOfBirth,address);
        this.grade = grade;
        this.school = school;
    }

    public Student(int id, String name, String dateOfBirth, String address, String grade, String school, double mark) {
        this(id, name, dateOfBirth, address, grade, school);
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                ", mark=" + mark +
                '}';
    }
}
