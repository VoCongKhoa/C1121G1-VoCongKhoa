package ss4_lop_va_doi_tuong_trong_java.bai_tap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a: ");
        double a = sc.nextDouble();
        System.out.println("Input b: ");
        double b = sc.nextDouble();
        System.out.println("Input c: ");
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (a == 0.0) {
            if (b == 0.0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many roots!");
                } else {
                    System.out.println("The equation has no root!");
                }
            } else {
                System.out.println("The equation has only one root: " + quadraticEquation.getRoot());
            }
        } else if (quadraticEquation.getA() + quadraticEquation.getB() + quadraticEquation.getC() == 0) {
            System.out.println("The equation has two roots: " + 1 + " and " + quadraticEquation.getC() / quadraticEquation.getA());
        } else if (quadraticEquation.getA() - quadraticEquation.getB() + quadraticEquation.getC() == 0) {
            System.out.println("The equation has two roots: " + -1 + " and " + -quadraticEquation.getC() / quadraticEquation.getA());
        } else if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no root!");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one duplicated roots: " + -quadraticEquation.getB() / (2 * quadraticEquation.getA()));
        } else {
            System.out.println("The equation has two roots: " + quadraticEquation.getRoot1() + " and " + quadraticEquation.getRoot2());
        }
    }
}

