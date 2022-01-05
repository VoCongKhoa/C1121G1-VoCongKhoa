package ss6_ke_thua.bai_tap.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input side 1 of triangle: ");
        double side1 = sc.nextDouble();
        System.out.println("Input side 2 of triangle: ");
        double side2 = sc.nextDouble();
        System.out.println("Input side 3 of triangle: ");
        double side3 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Input color of triangle: ");
        String color = sc.nextLine();
        System.out.println("Input true or false for filled triangle or not: ");
        boolean filled = sc.nextBoolean();
        Triangle triangle = new Triangle(color, filled, side1, side2, side3);
        System.out.println(triangle);
    }

}
