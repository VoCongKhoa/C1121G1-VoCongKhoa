package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class DisplayName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.printf("Hello: %s",name);
    }
}
