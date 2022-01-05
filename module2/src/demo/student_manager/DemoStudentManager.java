package demo.student_manager;

import java.util.Scanner;

public class DemoStudentManager {
    Scanner sc = new Scanner(System.in);
    Student[] studentList = new Student[10];

    public void createArr() {

        Student student1 = new Student(1, "ád", "ád", "ád", "ád", "ád", 10.0);
        Student student2 = new Student(2, "ád", "ád", "ád", "ád", "ád", 9.0);
        Student student3 = new Student(3, "ád", "ád", "ád", "ád", "ád", 8.0);
        studentList[0] = student1;
        studentList[1] = student2;
        studentList[2] = student3;

    }

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
        System.out.println("Choose id you wanna edit:");
        int idEdit = sc.nextInt();
        System.out.println("Choose property you wanna edit:\n" +
                "1.Edit id\n" +
                "2.Edit name\n" +
                "3.Edit dateOfBirth\n" +
                "4.Edit address\n" +
                "5.Edit grade\n" +
                "6.Edit school\n" +
                "7.Edit mark\n");
        int numEdit = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                break;
            }
            if (studentList[i].getId() == idEdit) {
                switch (numEdit) {
                    case 1:
                        System.out.println("Input new id:");
                        int newId = sc.nextInt();
                        studentList[i].setId(newId);
                        break;
                    case 2:
                        System.out.println("Input new name:");
                        String newName = sc.nextLine();
                        studentList[i].setName(newName);
                        break;
                    case 3:
                        System.out.println("Input new dateOfBirth:");
                        String newDateOfBirth = sc.nextLine();
                        studentList[i].setDateOfBirth(newDateOfBirth);
                        break;
                    case 4:
                        System.out.println("Input new address:");
                        String newAddress = sc.nextLine();
                        studentList[i].setAddress(newAddress);
                        break;
                    case 5:
                        System.out.println("Input new grade:");
                        String newGrade = sc.nextLine();
                        studentList[i].setGrade(newGrade);
                        break;
                    case 6:
                        System.out.println("Input new school:");
                        String newSchool = sc.nextLine();
                        studentList[i].setSchool(newSchool);
                        break;
                    case 7:
                        System.out.println("Input new mark:");
                        double newMark = sc.nextDouble();
                        studentList[i].setMark(newMark);
                        break;
                }
            }

        }

    }

    public void delete() {
        System.out.println("Input id you wanna delete:");
        int idDel = sc.nextInt();
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getId() == idDel) {
                for (int j = i; j < studentList.length; j++) {
                    if (j < studentList.length - 1) {
                        studentList[j] = studentList[j + 1];
                    } else {
                        studentList[j] = null;
                    }
                }
                break;
            }
        }
    }

    public void search() {

    }
}
