package ss12_java_collection_framework.thuc_hanh.comparable_va_comparator;

public class Student implements Comparable <Student>{
    private String name;
    private int age;
    private String address;
    private String className;

    public Student() {
    }

    public Student(String name, int age, String address, String className) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
        this.className =className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
