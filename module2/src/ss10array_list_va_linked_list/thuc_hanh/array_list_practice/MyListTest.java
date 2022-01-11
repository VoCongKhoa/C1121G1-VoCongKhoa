package ss10array_list_va_linked_list.thuc_hanh.array_list_practice;

import ss10array_list_va_linked_list.thuc_hanh.array_list_practice.MyListPractice;

public class MyListTest {
    public static void main(String[] args) {
        MyListPractice<Integer> listInteger = new MyListPractice<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.getElement(4));
        System.out.println("element 1: "+listInteger.getElement(1));
        System.out.println("element 2: "+listInteger.getElement(2));

//        listInteger.getElement(-1);
//        System.out.println("element -1: " + listInteger.getElement(-1));
    }
}
