import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();

        Pattern pattern = Pattern.compile("(?<symbol>[^0-9]+)(?<num>\\d+)+");
        Matcher matcher = pattern.matcher(input);

        StringBuilder resultRage = new StringBuilder();
        StringBuilder keyRage = new StringBuilder();
        List<Character> symbols = new ArrayList<>();
        while (matcher.find()) {
            String rageQuit = matcher.group("symbol");
            String repetitions = matcher.group("num");

            int reps = Integer.parseInt(String.valueOf(repetitions));
            if (reps != 0) {
                keyRage.append(rageQuit);
                for (int i = 0; i < reps; i++) {
                    resultRage.append(rageQuit);
                }
            }
        }

        for (char c : keyRage.toString().toCharArray()) {
            if (!Character.isDigit(c)) {
                if (!symbols.contains(c)) {
                    symbols.add(c);
                }
            }
        }
        Collections.sort(symbols);
        System.out.println("Unique symbols used: " + symbols.size());
        System.out.println(resultRage);
    }
}

