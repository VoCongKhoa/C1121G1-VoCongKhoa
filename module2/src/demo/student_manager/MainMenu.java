package demo.student_manager;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DemoStudentManager studentManager = new DemoStudentManager();
//        studentManager.createArr();
        int choice = -1;
        while (choice != 6) {
            displayMainMenu();
            System.out.print("Input your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add");
                    studentManager.add();
                    break;
                case 2:
                    System.out.println("Display");
                    studentManager.display();
                    break;
                case 3:
                    System.out.println("Edit");
//                    studentManager.edit();
                    break;
                case 4:
                    System.out.println("Delete");
//                    studentManager.delete();
                    break;
                case 5:
                    System.out.println("show method");
                    studentManager.showMethod();
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }
    }
    static void displayMainMenu() {
        System.out.println("1.\tAdd\n" +
                "2.\tDisplay\n" +
                "3.\tEdit\n" +
                "4.\tDelete\n" +
                "5.\tShow method\n" +
                "6.\tExit\n");
    }
}
