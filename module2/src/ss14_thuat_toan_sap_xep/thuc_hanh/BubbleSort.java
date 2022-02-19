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
        integerList.add(1);
        integerList.add(0);
        integerList.add(54);
        integerList.add(78);
        integerList.add(-78);
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
            System.out.println(array);
        }
        return array;
    }

    //Có flag tối ưu hơn
    public static ArrayList<Integer> bubbleSortDemo(ArrayList<Integer> array) {
        boolean flag = true; //Cần phải sắp xếp
        for (int i = 0; i < array.size() && flag; i++) {
            flag = false; //Đã sx
            for (int j = array.size()-1; j >i; j--) {
                if (array.get(j)<array.get(j-1)){
                    int temp = array.get(j);
                    array.set(j,array.get(j-1));
                    array.set(j-1,temp);
                    flag = true;//Cần sắp xếp
                }
            }
        }
        return array;
    }
}
