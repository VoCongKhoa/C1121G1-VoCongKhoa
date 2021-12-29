package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float width;
        float height;
        System.out.println("Input width: ");
        width = sc.nextFloat();
        System.out.println("Input height: ");
        height = sc.nextFloat();
        System.out.println("S of Rectangle: " + width * height);
    }
}
