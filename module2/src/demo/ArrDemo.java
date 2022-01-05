package demo;

import java.util.Arrays;

public class ArrDemo {
    public static void main(String[] args) {
        int[] arrA = {7, 2, 5, 3, 9, 9, 5, 3};
        int[] arrB = {7, 2, 5, 4, 6, 6, 6, 3, 5, 3};
        int[] arrC = new int[arrA.length + arrB.length];
        int[] arrD = new int[arrA.length + arrB.length];
        int[] arrE = new int[arrA.length + arrB.length];
        int countC = 0;
        int countE = 0;
        for (int i = 0; i < arrA.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arrB.length; j++) {
                if (arrA[i] == arrB[j]) {
                    flag = false;
                    arrD[j] = arrB[j];
                    break;
                }
            }
            if (flag) {
                arrC[i] = arrA[i];
                countC++;
            }
        }
        for (int i = 0; i < arrB.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arrD.length; j++) {
                if (arrB[i] == arrD[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arrE[i] = arrB[i];
                countE++;
            }
        }
        System.out.println(Arrays.toString(arrC));
//        System.out.println(Arrays.toString(arrD));
        System.out.println(Arrays.toString(arrE));
        int[] arrResult = new int[countC + countE];

        for (int i = 0; i < arrResult.length; i++) {
            int temp = 0;
            for (int j = 0; j < arrE.length; j++) {
//                if (arrE[j]==arrResult[i]){
//                    break;
//                }
                if (arrE[j] != 0) {
                    arrResult[i] = arrE[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arrResult));
        System.out.println(countC);
        System.out.println(countE);
//        selectionSort(arrC);
//        System.out.println(Arrays.toString(arrC));
//        System.out.println(count);
//        int[] arrD = new int[count];
//        for (int i = 0; i < arrC.length; i++) {
//            for (int j = 0; j < count; j++) {
//                if (arrC[i] != 0) {
//                    arrD[j] = arrC[i];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arrD));
    }

//    public static long[] selectionSort(int[] arr) {
//        int length = arr.length;
//        for (int i = 0; i < length - 1; i++) {
//            int minPos = i;
//            for (int j = i + 1; j < length; j++) {
//                if (arr[minPos] > arr[j]) {
//                    minPos = j;
//                }
//            }
//            int temp = arr[minPos];
//            arr[minPos] = arr[i];
//            arr[i] = temp;
//        }
//        return new long[0];
//    }
}
