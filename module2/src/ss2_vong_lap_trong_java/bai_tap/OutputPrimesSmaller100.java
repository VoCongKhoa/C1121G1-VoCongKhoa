package ss2_vong_lap_trong_java.bai_tap;

public class OutputPrimesSmaller100 {
    public static void main(String[] args) {
        int prime = 2;
        while (prime <= 100) {
            int i = 2;
            boolean check = true;
            while (i < prime) {
                if (prime % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                if (prime<100){
                    System.out.println(prime + " is prime!");
                } else {
                    prime++;
                }
            }
            prime++;
        }
    }
}
