import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0) {
                array1[i] = input[0];
                array2[i] = input[1];
            } else {
                array1[i] = input[1];
                array2[i] = input[0];
            }
        }
        for (int j : array1) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : array2) {
            System.out.print(j + " ");
        }
    }
}




