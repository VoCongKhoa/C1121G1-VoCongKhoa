package ss17_binary_file_and_serialization.thuc_hanh.doc_ghi_class_student_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> studentList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "A", "ĐN"));
        studentList.add(new Student(2, "B", "QN"));
        studentList.add(new Student(3, "ABC", "QN"));
        studentList.add(new Student(4, "BB", "SG"));
        studentList.add(new Student(5, "CC", "ĐN"));
        writeToFile("src/ss17_binary_file_and_serialization/thuc_hanh/doc_ghi_class_student_ra_file_nhi_phan/Student.txt",
                studentList);
        List<Student> studentDataFromFile = readDataFromFile("src/ss17_binary_file_and_serialization/thuc_hanh/doc_ghi_class_student_ra_file_nhi_phan/Student.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
}
