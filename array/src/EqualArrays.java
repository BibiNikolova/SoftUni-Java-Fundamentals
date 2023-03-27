import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        boolean areIdent = true;

        for (int i = 0; i < firstArray.length; i++) {
            sum += firstArray[i];

            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areIdent = false;
                break;
            }
        }
        if (areIdent) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}

