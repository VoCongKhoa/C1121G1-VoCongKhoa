package demo;

import java.util.ArrayList;

public class PrefixSums {
    public static void main(String[] args) {
//        ArrayList <Integer>mainArr = new ArrayList<>();
//        ArrayList <Integer>mainArr2 = new ArrayList<>();
//
//        int[] firstArr = {1,2,3};
//        Integer temp =0;
//        for (int i = 0; i < 3; i++) {
//            mainArr.add(firstArr[i]);
////            System.out.println(mainArr.get(i));
//            temp +=  mainArr.get(i);
//            System.out.println(temp);
//        }
//        ArrayList <Integer> arrA = new ArrayList<>();
//        arrA.add(1);
//        arrA.add(2);
//        arrA.add(3);
////        solutionArr(arrA);
//        ArrayList <Integer> arrB = new ArrayList<>(arrA.size());
//        arrB.add(0);
//        for (int i = 0; i < arrA.toArray().length-1; i++) {
//            arrB.set(i,arrB.get(i) + arrA.get(i + 1));
//            System.out.println(arrB.get(i));
//        }
////        for (Integer element: arrB) {
////            System.out.println(arrB);
////        }

        solution(new int[]{1, 2, 3});
    }
    public static ArrayList<Integer> solution(int[] inputArr){
        ArrayList <Integer>mainArr = new ArrayList<>();
        ArrayList <Integer>mainArr2 = new ArrayList<>();
        Integer temp =0;
        for (int i = 0; i < 3; i++) {
            mainArr.add(inputArr[i]);
            temp +=  mainArr.get(i);
            mainArr2.add(temp);
        }
        return mainArr2;
    }
}
