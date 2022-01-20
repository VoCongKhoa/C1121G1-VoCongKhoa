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
        integerList.add(-45);
        integerList.add(-45);
        System.out.println(integerList);
        System.out.println(insertSortDemo(integerList));
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

    //Thầy Chánh làm
    public static ArrayList<Integer> insertSortDemo(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int currentPosition = i;
            int tempValue = array.get(i);
            //Giá trị lấy ra để ss tempValue để ss với từng giá trị trong mảng con
            //Nếu tempValue nhỏ hơn giá trị tại vị trí currentPosition-1,
            //thì mới gán giá trị currentPosition = giá trị currentPosition-1
            //Nếu tempValue nhỏ hơn giá trị tại vị trí currentPosition-1,
            //thì gán giá trị currentPosition = giá trị tempValue.
            while (currentPosition > 0 && tempValue < array.get(currentPosition-1)) {
                array.set(currentPosition,array.get(currentPosition-1));
                currentPosition--;
            }
            array.set(currentPosition,tempValue);
        }
        return array;
    }
}
