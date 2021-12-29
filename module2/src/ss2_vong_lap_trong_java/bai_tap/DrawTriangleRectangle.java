package ss2_vong_lap_trong_java.bai_tap;

//import java.util.Objects;
import java.util.Scanner;

public class DrawTriangleRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chooseNumber = -1;
        while (chooseNumber != 4) {
            System.out.println("Menu:\n" +
                    "1.Print the rectangle\n" +
                    "2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right)\n" +
                    "3.Print isosceles triangle\n" +
                    "4.Exit");
            System.out.println("Input your choose: ");
            chooseNumber = sc.nextInt();
            switch (chooseNumber) {
                case 1:
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
                case 2:
                    System.out.println("Input height: ");
                    int h = sc.nextInt();
                    System.out.println("Input style: ");
                    String style = sc.next();
//                if (Objects.equals(style, "top-left")) {
                    switch (style) {
                        case "top-left":
                            for (int i = 1; i < h + 1; i++) {
                                for (int j = 0; j < i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("\n");
                            }
                            break;
                        case "top-right":
                            for (int i = 1; i < h + 1; i++) {
                                for (int j = i; j < h + 1; j++) {
                                    System.out.print(" ");
                                }
                                for (int k = 0; k < i; k++) {
                                    System.out.print("*");
                                }
                                System.out.println("\n");
                            }
                            break;
                        case "bottom-left":
                            for (int i = 0; i < h; i++) {
                                for (int j = i; j < h; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("\n");
                            }
                            break;
                        case "bottom-right":
                            for (int i = 1; i < h + 1; i++) {
                                for (int k = 0; k < i; k++) {
                                    System.out.print(" ");
                                }
                                for (int j = i; j < h + 1; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("\n");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Input height: ");
                    int h3 = sc.nextInt();
                    for (int i = 1; i < h3 + 1; i++) {
                        for (int j = i; j < h3 + 1; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < (2 * i - 1); k++) {
                            System.out.print("*");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number! Choose again!");
            }
        }
    }

}
