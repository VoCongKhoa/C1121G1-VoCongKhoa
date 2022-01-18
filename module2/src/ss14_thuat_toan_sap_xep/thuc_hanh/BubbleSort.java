package ss14_thuat_toan_sap_xep.thuc_hanh;

import java.util.ArrayList;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(45);
        integerList.add(12);
        integerList.add(46);
        integerList.add(32);
        integerList.add(1);
        integerList.add(54);
        integerList.add(78);
        System.out.println(integerList);
        System.out.println(bubbleSort(integerList));
    }
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = 0; j < array.size()-i; j++) {
                if (array.get(j)>array.get(j+1)){
                    int temp = array.get(j);
                    array.set(j,array.get(j+1));
                    array.set(j+1,temp);
                }
            }
        }
        return array;
    }
}
