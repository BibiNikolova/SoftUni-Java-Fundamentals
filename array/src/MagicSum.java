import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program, which prints all unique pairs in
        // an array of integers whose sum is equal to a given number.
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int givenNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == givenNum) {
                    System.out.println(input[i] + " " + input[j]);
                }
            }
        }
    }
}
