package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input width: ");
        int width = sc.nextInt();
        System.out.println("Input height: ");
        int height = sc.nextInt();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println(rectangle.display());
    }
}
