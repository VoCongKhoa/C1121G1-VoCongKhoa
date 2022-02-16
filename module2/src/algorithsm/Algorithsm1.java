package algorithsm;

import java.util.Arrays;

public class Algorithsm1 {
    public static void main(String[] args) {

        int[] intArray = {-1, 150, 190, 170, -1, -1, 160, 180};
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != -1) {
                int minIndex = i;
                for (int j = i + 1; j < intArray.length; j++) {
                    if (intArray[j] != -1) {
                        if (intArray[minIndex] > intArray[j]) {
                            minIndex = j;
                        }
                    }
                }
                if (minIndex != i) {
                    int temp = intArray[minIndex];
                    intArray[minIndex] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }
    }
}
