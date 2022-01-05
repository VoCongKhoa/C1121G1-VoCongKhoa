package FuramaResort.models;

public abstract class Person {
    private String name;
    private int age;
    private String dateOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, int age, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", dateOfBirth = " + dateOfBirth +
                ", gender = " + gender+
                ", idNumber = " + idNumber+
                ", phoneNumber = " + phoneNumber+
                ", email = " + email+
                '}';
    }
}
