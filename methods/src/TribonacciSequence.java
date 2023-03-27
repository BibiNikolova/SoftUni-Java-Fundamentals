import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTribRec(n);
    }

    //Recursion function
    private static void printTribRec(int n) {

        int[] trib = new int[n];
        for (int i = 0; i < n; i++) {

            if (i == 0 || i == 1) {
                trib[i] = 1;
            } else if (i == 2) {
                trib[i] = 2;
            } else {
                int currentN = trib[i - 1] + trib[i - 2] + trib[i - 3];
                trib[i] = currentN;
            }
        }
        for (int i : trib) {
            System.out.print(i + " ");
        }
    }
}
