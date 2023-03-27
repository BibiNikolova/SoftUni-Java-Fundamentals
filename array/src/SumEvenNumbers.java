import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            if(num[i] % 2 == 0) {
                sum += num[i];
            }
        }
        System.out.println(sum);
    }
}
