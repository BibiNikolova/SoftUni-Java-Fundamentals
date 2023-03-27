import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reads a sequence of strings from the console. Encrypt every string by summing:
        //•	The code of each vowel multiplied by the string length
        //•	The code of each consonant divided by the string length
        //Sort the number sequence in ascending order and print it on the console.
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        String nameSums = "";

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            for (int index = 0; index < name.length(); index++) {
                boolean isVowel = false;

                if (name.charAt(index) == 'a' || name.charAt(index) == 'e' || name.charAt(index) == 'i'
                        || name.charAt(index) == 'o' || name.charAt(index) == 'u' || name.charAt(index) == 'A'
                        || name.charAt(index) == 'E' || name.charAt(index) == 'I' || name.charAt(index) == 'O' || name.charAt(index) == 'U') {
                    isVowel = true;
                }
                if (!isVowel) {
                    sum += name.charAt(index) / name.length();
                } else {
                    sum += name.charAt(index) * name.length();
                }
            }
            nameSums += sum + " ";
            sum = 0;
        }
        int[] ascendingOrder = Arrays.stream(nameSums.split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < ascendingOrder.length; i++) {
            for (int j = i + 1; j < ascendingOrder.length; j++) {
                int temp = 0;
                if (ascendingOrder[i] > ascendingOrder[j]) {
                    temp = ascendingOrder[i];
                    ascendingOrder[i] = ascendingOrder[j];
                    ascendingOrder[j] = temp;
                }
            }
            System.out.println(ascendingOrder[i]);
        }
    }
}
