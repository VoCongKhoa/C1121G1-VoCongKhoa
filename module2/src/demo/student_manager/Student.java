package demo.student_manager;

import java.util.Objects;

public class Student extends Person {
    private String className;
    private double mark;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.mark, mark) == 0 && Objects.equals(className, student.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, mark);
    }

    public Student(String className, double mark) {
        this.className = className;
        this.mark = mark;
    }

    public Student(int id, String name, String dateOfBirth, int age, String address, String className, double mark) {
        super(id, name, dateOfBirth, age, address);
        this.className = className;
        this.mark = mark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
                "className='" + className + '\'' +
                ", mark=" + mark +
                '}';
    }

    public void study(String subject) {
        System.out.println("Study " + subject);
    }

    public String isClass() {
        return "Study " + className;
    }

    public void goToBy(String vehicle) {
        System.out.println("Go to school by " + vehicle);
    }
}
