package demo.student_manager;

import java.util.Scanner;

public class DemoStudentManager {
    Scanner sc = new Scanner(System.in);
    Student[] studentList = new Student[10];

    public void add() {
        System.out.println("Input id:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input dateOfBirth:");
        String dateOfBirth = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input grade:");
        String grade = sc.nextLine();
        System.out.println("Input school:");
        String school = sc.nextLine();
        System.out.println("Input mark:");
        double mark = sc.nextDouble();
        Student student = new Student(id, name, dateOfBirth, address, grade, school, mark);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }

        }
    }

    public void display() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                break;
            } else {
                System.out.println(studentList[i]);
            }
        }
    }

    public void edit() {

    }

    public void delete() {
        System.out.println("Input id you wanna delete:");
        int idDel = sc.nextInt();
//        boolean check = (studentList[0].getId() == idDel);
//        System.out.println(studentList[0].getId() == idDel);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getId() == idDel) {
                for (int j = i; j < studentList.length; j++) {
                    if (j<studentList.length-1){
                        studentList[j] = studentList[j+1];
                    } else {
                        studentList[j] = null;
                    }
                }
                i--;
            }
        }
    }
    public void search() {

    }
}
