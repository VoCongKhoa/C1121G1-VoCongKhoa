package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ConvertDegree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose=-1;
        while (choose!=0){
            System.out.println("1. Fahrenheit to Celsius\n" +
                    "2. Celsius to Fahrenheit\n" +
                    "0. Exit ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Input Fahrenheit: ");
                    float fahrenheit = sc.nextFloat();
                    System.out.printf("%fF = : %fC\n", fahrenheit, FahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Input Celsius: ");
                    float celsius = sc.nextFloat();
                    System.out.printf("%fC = : %fF\n", celsius, CelsiusToFahrenheit(celsius));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    public static float FahrenheitToCelsius(float fahrenheit) {
        float celsius = (float) ((5.0 / 9) * (fahrenheit - 32));
        return celsius;
    }
    public static float CelsiusToFahrenheit(float celsius) {
        float fahrenheit = (float) ((9.0 / 5) * celsius + 32);
        return fahrenheit;
    }
}
