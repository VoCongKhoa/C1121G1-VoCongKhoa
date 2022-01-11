package ss10array_list_va_linked_list.bai_tap.array_list;

import java.util.Arrays;

public class MyCreatedArrayListTest {
    public static void main(String[] args) {
        MyCreatedArrayList<String> myCreatedArrayList1 = new MyCreatedArrayList<>();
        MyCreatedArrayList<Integer> myCreatedArrayList2 = new MyCreatedArrayList<>(5);
        myCreatedArrayList1.add(0, "10");
        myCreatedArrayList1.add(1, "5");
        myCreatedArrayList1.add(2, "3");
        myCreatedArrayList1.add(1, "6");

        System.out.println("myList1[0] = " + myCreatedArrayList1.get(0));
        System.out.println("myList1[1] = " + myCreatedArrayList1.get(1));
        System.out.println("myList1[2] = " + myCreatedArrayList1.get(2));
        System.out.println("myList1[3] = " + myCreatedArrayList1.get(3));

        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");
        myCreatedArrayList1.add("100");

        System.out.println("myList1[0] = " + myCreatedArrayList1.get(0));
        System.out.println("myList1[1] = " + myCreatedArrayList1.get(1));
        System.out.println("myList1[2] = " + myCreatedArrayList1.get(2));
        System.out.println("myList1[3] = " + myCreatedArrayList1.get(3));
        System.out.println("myList1[4] = " + myCreatedArrayList1.get(4));
        System.out.println("myList1[5] = " + myCreatedArrayList1.get(5));
        System.out.println("myList1[6] = " + myCreatedArrayList1.get(6));
        System.out.println("myList1[7] = " + myCreatedArrayList1.get(7));
        System.out.println("myList1[8] = " + myCreatedArrayList1.get(8));
        System.out.println("myList1[9] = " + myCreatedArrayList1.get(9));
        System.out.println("myList1[10] = " + myCreatedArrayList1.get(10));
        System.out.println("myList1[11] = " + myCreatedArrayList1.get(11));

    }
}
