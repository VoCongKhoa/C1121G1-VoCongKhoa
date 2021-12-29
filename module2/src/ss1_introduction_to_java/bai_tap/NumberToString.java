package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Enter your number:");
        number = sc.nextInt();
        int number1st = number / 100;//1,2,3,4,5
        int number2nd = (number - number1st * 100) / 10;//11,22,33,44
        int number3rd = (number - number1st * 100 - number2nd * 10);//111,112,113
        if (number < 10) {
            if (number == 0) {
                System.out.println("Zero");
            } else {
                System.out.println(OneNumberReturn(number));
            }
        } else if (number < 100) {
            if (number > 10 && number < 20) {
                System.out.println(SpecialReturn(number));
            } else {
                System.out.printf("%s %s", TwoNumberReturn(number2nd), OneNumberReturn(number3rd));
            }
        } else if (number < 1000) {
            if (number % 100 == 0) {
                System.out.printf("%s hundred", OneNumberReturn(number1st));
            } else if (number % 100 > 10 && number % 100 < 20) {
                System.out.printf("%s hundred and %s", OneNumberReturn(number1st), SpecialReturn(number % 100));
            } else {
                System.out.printf("%s hundred and %s %s", OneNumberReturn(number1st), TwoNumberReturn(number2nd), OneNumberReturn(number3rd));
            }
        } else {
            System.out.println("Bạn hãy nhập số từ 0-999!");
        }
    }

    public static String OneNumberReturn(int number) {
        String word = "";
        switch (number) {
            case 1:
                word = "one";
                break;
            case 2:
                word = "two";
                break;
            case 3:
                word = "three";
                break;
            case 4:
                word = "four";
                break;
            case 5:
                word = "five";
                break;
            case 6:
                word = "six";
                break;
            case 7:
                word = "seven";
                break;
            case 8:
                word = "eight";
                break;
            case 9:
                word = "nine";
                break;
        }
        return word;
    }

    public static String TwoNumberReturn(int number) {
        String word = "";
        switch (number) {
            case 1:
                word = "ten";
                break;
            case 2:
                word = "twenty";
                break;
            case 3:
                word = "thirdty";
                break;
            case 4:
                word = "fourty";
                break;
            case 5:
                word = "fifty";
                break;
            case 6:
                word = "sixty";
                break;
            case 7:
                word = "seventy";
                break;
            case 8:
                word = "eighty";
                break;
            case 9:
                word = "ninety";
                break;
            default:
                word = "";
        }
        return word;
    }

    public static String SpecialReturn(int number) {
        String word = "";
        switch (number) {
            case 11:
                word = "eleven";
                break;
            case 12:
                word = "twelve";
                break;
            case 13:
                word = "thirdteen";
                break;
            case 14:
                word = "fourteen";
                break;
            case 15:
                word = "fifteen";
                break;
            case 16:
                word = "sixteen";
                break;
            case 17:
                word = "seventeen";
                break;
            case 18:
                word = "eighteen";
                break;
            case 19:
                word = "nineteen";
                break;
            default:
                word = "";
        }
        return word;
    }
}
