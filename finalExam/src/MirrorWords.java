import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Matcher matcher = Pattern.compile("([@#])(?<first>[A-za-z]{3,})\\1\\1(?<second>[A-za-z]{3,})\\1").matcher(input);
        int count = 0;
        List<String> pairs = new ArrayList<>();

        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String reversedWord = matcher.group("second");
            StringBuilder r = new StringBuilder(firstWord);
            if (r.reverse().toString().equals(reversedWord)) {
                pairs.add(firstWord + " <=> " + reversedWord);
            }
            count++;
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(count + " word pairs found!");
        }

        if (pairs.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < pairs.size(); i++) {
                if (i != pairs.size() - 1) {
                    System.out.printf("%s, ", pairs.get(i));
                } else {
                    System.out.println(pairs.get(i));
                }
            }
        }
    }
}
