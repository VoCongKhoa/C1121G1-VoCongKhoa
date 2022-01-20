package ss15_xu_li_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class TestTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập a: ");
        int a = scanner.nextInt();
        System.out.println("Hãy nhập b: ");
        int b = scanner.nextInt();
        System.out.println("Hãy nhập c: ");
        int c = scanner.nextInt();
        TestTriangleException triangleCheck = new TestTriangleException();
        triangleCheck.checkTriangle(a, b, c);
    }

    static void validate(int a, int b, int c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a || a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Not valid");
        } else
            System.out.println("You inputed a triangle (" + a + "," + b + "," + c + ")");
    }

    private void checkTriangle(int a, int b, int c) {
        try {
            validate(a,b,c);
        } catch (Exception e) {
            System.out.println("You input wrong number of triangle!!!");
        }
    }
}
