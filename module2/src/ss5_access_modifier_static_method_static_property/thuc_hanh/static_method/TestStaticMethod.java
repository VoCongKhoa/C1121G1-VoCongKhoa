package ss5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class TestStaticMethod {
    public static void main(String args[]) {
        Student.changeSchool();

        Student s1 = new Student(123, "Vo");
        Student s2 = new Student(456, "Cong");
        Student s3 = new Student(789, "Khoa");

        s1.display();
        s2.display();
        s3.display();
    }
}
