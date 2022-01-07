package demo.student_manager;

public class Person {
    private int id;
    private String name;
    private String dateOfBirth;
    private int age;
    private String address;

    public Person() {
    }

    public Person(int id, String name, String dateOfBirth, int age, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.address = address;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
