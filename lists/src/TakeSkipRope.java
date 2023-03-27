import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> numbers = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                numbers.add(String.valueOf(input.charAt(i)));
            } else {
                letters.add(String.valueOf(input.charAt(i)));
            }
        }
        List<String> decrypted = new ArrayList<>();
        int currentIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int digit = Integer.parseInt(numbers.get(i));
            if (i % 2 == 0) {
                decrypted.addAll(letters.subList(currentIndex, currentIndex + digit));
                currentIndex += digit;
            } else {
                currentIndex += digit;
            }
        }
        /*System.out.println(decrypted.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .replace(",", "")
                .trim());*/
        System.out.println(String.join("",decrypted));
    }
}
