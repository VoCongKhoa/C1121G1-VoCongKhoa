package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a;
        float b;
        float c;
        System.out.println("Input a:");
        a = sc.nextFloat();
        System.out.println("Input b:");
        b = sc.nextFloat();
        System.out.println("Input c:");
        c = sc.nextFloat();

        if (a == 0) {
            if (b==c) {
                System.out.println("Phương trình có vô số nghiệm!");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        } else {
            float result = (c-b)/a;
            System.out.printf("Phương trình có nghiệm là: %.3f",result);
        }
    }
}
