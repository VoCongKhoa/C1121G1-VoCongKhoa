package ss10_array_list_va_linked_list.thuc_hanh.linked_list_practice;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("TESTING");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4, 9);
        ll.add(4, 9);
        ll.printList();
    }
}
