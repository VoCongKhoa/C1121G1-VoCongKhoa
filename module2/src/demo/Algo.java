package demo;

import java.util.*;
public class Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number:");
        int number = sc.nextInt();
        System.out.println(findNumeber(number));
    }
    public static int findNumeber(int number){
        Map<Integer,Integer> integerMap = new TreeMap<>();
        for (int i = 1; i <= number + 1; i++) {
            if (number % i == 0) {
                integerMap.put(i,number/i);
            }
        }
        int min = number*10 + 1;
        for (Map.Entry<Integer,Integer> entry : integerMap.entrySet()) {
            if (entry.getValue()<10){
                if (entry.getKey()*10+entry.getValue()< min){
                    min = entry.getKey()*10+entry.getValue();
                }
            }
        }
        if (integerMap.size()==2){
            return -1;
        }else {
            return min;
        }
    }
}
