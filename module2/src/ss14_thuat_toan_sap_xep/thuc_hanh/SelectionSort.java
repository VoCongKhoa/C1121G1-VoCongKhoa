package ss14_thuat_toan_sap_xep.thuc_hanh;

import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(45);
        integerList.add(12);
        integerList.add(46);
        integerList.add(32);
        integerList.add(1);
        integerList.add(1);
        integerList.add(0);
        integerList.add(54);
        integerList.add(78);
        integerList.add(-78);
        System.out.println(integerList);
        System.out.println(selectionSort(integerList));
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int minIndex = i;
            //Tìm giá trị nhỏ nhất trong dãy hiện hành
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(minIndex) > array.get(j)) {
                    minIndex = j;
                }
            }
            //Swap minIndex với giá trị đầu tiên của dãy hiện hành
            if (minIndex != i) {
                int temp = array.get(minIndex);
                array.set(minIndex, array.get(i));
                array.set(i, temp);
            }
        }
        return array;
    }
}
