package ss15_xu_li_ngoai_le_va_debug.thuc_hanh;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArrayIndexOutOfBoundsException {
    public static void main(String[] args) {

        MyArrayIndexOutOfBoundsException arrayExample = new MyArrayIndexOutOfBoundsException();
        Integer[] numberArray = arrayExample.createRandom();
//
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int inputNumber = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + inputNumber + " là " + numberArray[inputNumber]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng!!");
        }
    }
    public Integer[] createRandom() {
        Random random = new Random();
        Integer[] array = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
