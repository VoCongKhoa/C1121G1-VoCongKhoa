package ss11_stack_va_queue.bai_tap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class ReverseByStack {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
//        Stack<String> stringStack = new Stack<>();
        int[] integerArray = {1, 2, 3, 4, 5};
//        String[] stringArray = {"a","b","c","d","e"};
        System.out.println("Before reverse:");
        System.out.println(Arrays.toString(integerArray));
        int size = integerArray.length;
        for (int i = 0; i < size; i++) {
            integerStack.push(integerArray[i]);
        }
        for (int i = 0; i < size; i++) {
            integerArray[i] = integerStack.pop();
        }
        System.out.println("After reverse:");
        System.out.println(Arrays.toString(integerArray));
    }
}
