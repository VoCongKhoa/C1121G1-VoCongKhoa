public class Algorothism {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j>i){
                    System.out.print("**");
                } else {
                    System.out.println("  ");
                }
            }
            System.out.println("");
        }
    }
}
