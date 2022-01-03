package ss5_access_modifier_static_method_static_property.bai_tap;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
class Test{
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Khoa");
        student.setClasses("C1121G1");
        System.out.println(student.getName());
        System.out.println(student.getClasses());
    }
}
