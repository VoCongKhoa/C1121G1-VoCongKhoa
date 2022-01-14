package ss12_java_collection_framework.thuc_hanh.comparable_va_comparator;

import java.util.*;

public class Main {
    static List<Student> studentList = new ArrayList<Student>();

    static {
        studentList.add(new Student("Khoa", 28, "ĐN", "C1121G1"));
        studentList.add(new Student("Vo", 29, "QN", "C1221G1"));
        studentList.add(new Student("Cong", 30, "Hue", "C1021G1"));
        studentList.add(new Student("Su", 26, "SG", "C0921G1"));
        studentList.add(new Student("Uyen", 25, "HN", "C0821G1"));
    }

    public static void main(String[] args) {

        NameAndAgeComparator nameAndAgeComparator = new NameAndAgeComparator();
        //Comparable
        Collections.sort(studentList);
        //Comparator
        Collections.sort(studentList,nameAndAgeComparator);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
