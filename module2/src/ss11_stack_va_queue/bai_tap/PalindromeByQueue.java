package ss11_stack_va_queue.bai_tap;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class PalindromeByQueue {
    public static void main(String[] args) {
        String inputString = "Able was I ere I saw Elba";
        inputString = inputString.toLowerCase();
//        Queue<String> stringQueue = new LinkedList<>();
        Stack<String> stringStack = new Stack<>();
        int size = inputString.length();
        for (int i = 0; i < size; i++) {
            stringStack.push(inputString.charAt(i)+"");
        }
        String reverseString ="";
        for (int i = 0; i < size; i++) {
            reverseString = reverseString + stringStack.pop();
        }
        System.out.println(inputString);
        System.out.println(reverseString);
        System.out.println(inputString.equals(reverseString));
    }
}
