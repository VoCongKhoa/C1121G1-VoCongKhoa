package ss10array_list_va_linked_list.bai_tap.linked_list;

public class MyCreatedLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyCreatedLinkedList() {
    }

    public MyCreatedLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
    }

    public E remove(int index){
        return (E) "E;";
    }

    public boolean remove(Object e){
        return true;
    }

    public int size(){
        return 1;
    }

    public E clone(){
        return (E) "a";
    }

    public boolean constains (E o){
        return true;
    }

    public int indexOf(E o){
        return 1;
    }

    public boolean add (E e){
        return true;
    }

    public void ensureCapacity(int minCapacity){

    }
    public Node get(int i){
        Node temp=head;
        for(int j=0; j<i; j++) {
            temp = temp.next;
        }
        return temp;
    }

    public E getFirst(){
        return (E) "a";
    }

    public E getLast(){
        return (E) "a";
    }

    public void clear(){

    }
}
