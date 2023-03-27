import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> parseInt(e)).toArray();
        int evenSum = 0;
        int oddSum = 0;
        for (int i : num) {
            if (i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
        }
        int diff = evenSum - oddSum;
        System.out.println(diff);
    }
}

