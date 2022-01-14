package ss11_stack_va_queue.bai_tap;

import java.util.Stack;

public class BracketByStack {
    public static void main(String[] args) {
//        System.out.println(balancedParenthensies("{(a,b)}"));
//        System.out.println(balancedParenthensies("{(a},b)"));
//        System.out.println(balancedParenthensies("{)(a,b}"));
        System.out.println(checkBracket("((a,b)))"));
        System.out.println(checkBracket("(((a),b)"));
        System.out.println(checkBracket("()(a,b)"));
    }

    public static boolean checkBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter == '(') {
                stack.push(letter);
            } else if (letter == ')') {
                if (stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

//    public static boolean balancedParenthensies(String str) {
//        Stack<Character> stack = new Stack<Character>();
//        for (int i = 0; i < str.length(); i++) {
//            char letter = str.charAt(i);
//            if (letter == '[' || letter == '(' || letter == '{') {
//                stack.push(letter);
//            } else if (letter == ']') {
//                if (stack.isEmpty() || stack.pop() != '[') {
//                    return false;
//                }
//            } else if (letter == ')') {
//                if (stack.isEmpty() || stack.pop() != '(') {
//                    return false;
//                }
//            } else if (letter == '}') {
//                if (stack.isEmpty() || stack.pop() != '{') {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
}
