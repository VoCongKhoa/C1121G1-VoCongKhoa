package demo;

public class AlgorithsmIsPronic {
    public static void main(String[] args) {
        System.out.println(isPronic(42));
    }

    public static boolean isPronic(int number) {
        boolean result = false;
        if (number == 0) {
            return true;
        } else {
            for (int i = 1; i < number; i++) {
                if (number == i*(i+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
