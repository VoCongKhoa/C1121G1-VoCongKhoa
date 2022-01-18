package ss14_thuat_toan_sap_xep.bai_tap;

import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(11);
        integerList.add(46);
        integerList.add(13);
        integerList.add(46);
        integerList.add(32);
        integerList.add(15);
        integerList.add(0);
        integerList.add(55);
        integerList.add(-45);
        System.out.println(integerList);
        System.out.println(insertSort(integerList));
    }

    public static ArrayList<Integer> insertSort(ArrayList<Integer> array) {
        int tempValue = 0;
        int currentValue = 0;
        for (int i = 0; i < array.size()-1; i++) {
            int currentPosition = i;
            while (currentPosition >= 0) {
                currentValue = array.get(currentPosition);
                tempValue = array.get(currentPosition + 1);
                if (tempValue < currentValue) {
                    array.set(currentPosition, tempValue);
                    array.set(currentPosition + 1, currentValue);
                }
                currentPosition--;
            }
        }
        return array;
    }
}
