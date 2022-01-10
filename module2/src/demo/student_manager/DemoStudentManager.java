package demo.student_manager;

import java.util.Scanner;

public class DemoStudentManager {
    Scanner sc = new Scanner(System.in);
    static Student[] studentList = new Student[10];
    static Teacher[] teacherList = new Teacher[10];
    static Person[] personList = new Person[20];

    static {
        Person student1 = new Student(1, "a", "12/1/2020", 16, "ád", "11A", 10.0);
        Person student2 = new Student(2, "b", "2/2/2020", 17, "ád", "12B", 9.0);
        Person student3 = new Student(3, "c", "3/3/2020", 18, "ád", "10C", 8.0);
        Person teacher1 = new Teacher(1, "AA", "10/1/2020", 26, "ád", "Toan", 10);
        Person teacher2 = new Teacher(2, "BB", "10/2/2020", 27, "ád", "Ly", 9);
        Person teacher3 = new Teacher(3, "CC", "10/3/2020", 38, "ád", "Hoa", 8);

        studentList[0] = (Student)student1;
        studentList[1] = (Student) student2;
        studentList[2] = (Student) student3;

        teacherList[0] = (Teacher) teacher1;
        teacherList[1] = (Teacher) teacher2;
        teacherList[2] = (Teacher) teacher3;

        personList[0] = student1;
        personList[1] = student2;
        personList[2] = student3;
        personList[3] = teacher1;
        personList[4] = teacher2;
        personList[5] = teacher3;


    }

    public void add() {
//        System.out.println("Input id:");
//        int id = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Input name:");
//        String name = sc.nextLine();
//        System.out.println("Input dateOfBirth:");
//        String dateOfBirth = sc.nextLine();
//        System.out.println("Input address:");
//        String address = sc.nextLine();
//        System.out.println("Input grade:");
//        String grade = sc.nextLine();
//        System.out.println("Input school:");
//        String school = sc.nextLine();
//        System.out.println("Input mark:");
//        double mark = sc.nextDouble();
        Person student = new Student();
        Person teacher = new Teacher();
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] == null) {
                personList[i] = student;
                personList[i+1] = teacher;
                break;
            }

        }
    }

    public void display() {
        for (Person person : personList) {
            if (person == null) {
                break;
            } else {
                System.out.println(person);
            }
        }
    }

//    public void edit() {
//        System.out.println("Choose id you wanna edit:");
//        int idEdit = sc.nextInt();
//        System.out.println("Choose property you wanna edit:\n" +
//                "1.Edit id\n" +
//                "2.Edit name\n" +
//                "3.Edit dateOfBirth\n" +
//                "4.Edit address\n" +
//                "5.Edit grade\n" +
//                "6.Edit school\n" +
//                "7.Edit mark\n");
//        int numEdit = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < studentList.length; i++) {
//            if (studentList[i] == null) {
//                break;
//            }
//            if (studentList[i].getId() == idEdit) {
//                switch (numEdit) {
//                    case 1:
//                        System.out.println("Input new id:");
//                        int newId = sc.nextInt();
//                        studentList[i].setId(newId);
//                        break;
//                    case 2:
//                        System.out.println("Input new name:");
//                        String newName = sc.nextLine();
//                        studentList[i].setName(newName);
//                        break;
//                    case 3:
//                        System.out.println("Input new dateOfBirth:");
//                        String newDateOfBirth = sc.nextLine();
//                        studentList[i].setDateOfBirth(newDateOfBirth);
//                        break;
//                    case 4:
//                        System.out.println("Input new address:");
//                        String newAddress = sc.nextLine();
//                        studentList[i].setAddress(newAddress);
//                        break;
//                    case 5:
//                        System.out.println("Input new grade:");
//                        String newGrade = sc.nextLine();
//                        studentList[i].setClassName(newGrade);
//                        break;
//                    case 6:
//                        System.out.println("Input new school:");
//                        String newSchool = sc.nextLine();
//                        studentList[i].setSchool(newSchool);
//                        break;
//                    case 7:
//                        System.out.println("Input new mark:");
//                        double newMark = sc.nextDouble();
//                        studentList[i].setMark(newMark);
//                        break;
//                }
//            }
//
//        }
//
//    }

//    public void delete() {
//        System.out.println("Input id you wanna delete:");
//        int idDel = sc.nextInt();
//        for (int i = 0; i < studentList.length; i++) {
//            if (studentList[i].getId() == idDel) {
//                for (int j = i; j < studentList.length; j++) {
//                    if (j < studentList.length - 1) {
//                        studentList[j] = studentList[j + 1];
//                    } else {
//                        studentList[j] = null;
//                    }
//                }
//                break;
//            }
//        }
//    }

    public void search() {

    }

    public void showMethod(){
        for (Person person : personList) {
            if (person==null){
                break;
            }
            if (person instanceof Student) {
                ((Student) person).study("Hoa");
            } else {
                ((Teacher) person).teach("Su");
            }
        }
    }
}
