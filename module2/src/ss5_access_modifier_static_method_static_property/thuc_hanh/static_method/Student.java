package ss5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class Student {
    private int number;
    private String name;
    private static String school = "DanangUniversityOfTechnology";

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student(int numb, String str) {
        number = numb;
        name = str;
    }


    static void changeSchool() {
        school = "CODEGYM";
    }


    void display() {
        System.out.println(number + " " + name + " " + school);
    }
}
