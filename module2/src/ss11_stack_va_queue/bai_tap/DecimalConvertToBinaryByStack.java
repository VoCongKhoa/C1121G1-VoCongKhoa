package ss11_stack_va_queue.bai_tap;

import java.util.Stack;

public class DecimalConvertToBinaryByStack {
    public static void main(String[] args) {
        Stack<Integer> binaryList = new Stack<>();
        int inputNumber = 111;
        int oneComplement = inputNumber >= 0 ? 0 : 1;
        while (inputNumber != 0) {
            int divided = Math.abs(inputNumber % 2);
            inputNumber = inputNumber / 2;
            binaryList.push(divided);
        }
        binaryList.push(oneComplement);
        System.out.println(binaryList);
    }
}
