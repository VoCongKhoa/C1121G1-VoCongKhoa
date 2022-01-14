package ss11_stack_va_queue.bai_tap;

import java.util.*;

public class TreeMapSolution {
    public static void main(String[] args) {
        String str = "Zero Nine Zero Five Four Seven Two Five Nine Two";
        Map<String, Integer> stringMap = new TreeMap<String, Integer>();

        String[] wordArray = str.toLowerCase().split(" ");

        for (String word : wordArray) {
            if (stringMap.isEmpty() || !stringMap.containsKey(word)) {
                stringMap.put(word, 1);
            } else {
                stringMap.replace(word, stringMap.get(word) + 1);
            }
        }
        System.out.println(stringMap);
    }
}
