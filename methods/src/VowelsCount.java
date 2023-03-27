import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printNumVowels(text);
    }

    private static void printNumVowels(String text) {
        int count = 0;//брой на гласните
        for (char symbol : text.toCharArray()) {//създава масив от символи
            if (symbol == 'a' || symbol == 'u' || symbol == 'o'
                    || symbol == 'i' || symbol == 'e') {
                count++;
            }
        }
        System.out.println(count);
    }
}
