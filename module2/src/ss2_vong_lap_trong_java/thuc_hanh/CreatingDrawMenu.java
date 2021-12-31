package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CreatingDrawMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chooseNumber = -1;
        while (chooseNumber != 0) {
            System.out.println("Menu:\n" +
                    "1.Print the triangle\n" +
                    "2.Print the square\n" +
                    "3.Print rectangle\n" +
                    "0.Exit");
            System.out.println("Input your choose: ");
            chooseNumber = sc.nextInt();
            switch (chooseNumber) {
                case 1:
                    System.out.println("Input height: ");
                    int h = sc.nextInt();
                    for (int i = 1; i < h + 1; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    System.out.println("Input size: ");
                    int a = sc.nextInt();
                    for (int i = 0; i < a; i++) {
                        for (int j = 0; j < a; j++) {
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    System.out.println("Input width: ");
                    int m = sc.nextInt();
                    System.out.println("Input height: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("**");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number! Choose again!");
            }
        }
    }
}
