package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float weight, height;
        System.out.println("Input weight: ");
        weight = sc.nextFloat();
        System.out.println("Input height: ");
        height = sc.nextFloat();
        float bmi = (float) (weight / (Math.pow(height, 2))); //????
        if (bmi < 18.5) {
            System.out.printf("BMi = %-10.2f%s", bmi, "Underweight");
        } else if (bmi < 25) {
            System.out.printf("BMi = %-10.2f%s", bmi, "Normal");
        } else if (bmi < 30) {
            System.out.printf("BMi = %-10.2f%s", bmi, "Overweight");
        } else {
            System.out.printf("BMi = %-10.2f%s", bmi, "Obese");
        }
    }
}
