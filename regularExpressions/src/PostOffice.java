import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        Map<Character, Integer> params = new LinkedHashMap<>();

        String firstPart = input[0];
        Pattern first = Pattern.compile("([#|\\$|%|*|&])[A-Z]+(\\1)");
        Matcher firstMatch = first.matcher(firstPart);
        if (firstMatch.find()) {
            String capitalLetter = firstMatch.group();
            for (int i = 0; i < capitalLetter.length(); i++) {
                if (i != 0 && i != capitalLetter.length() - 1) {
                    params.put(capitalLetter.charAt(i), 0);
                }
            }
        }

        String secondPart = input[1];
        Pattern second = Pattern.compile("(?<capital>[6][5-9]|[7-8][0-9]|[9][0]):(?<count>[0][1-9]|[1][0-9]|[2][0])");
        Matcher secondMatch = second.matcher(secondPart);

        while (secondMatch.find()) {
            int letterCode = Integer.parseInt(secondMatch.group("capital"));
            int length = Integer.parseInt(secondMatch.group("count"));
            if (params.containsKey((char) letterCode)) {
                params.put((char) letterCode, length);
            }
        }

        String[] thirdPart = input[2].split("\\s+");
        for (Map.Entry<Character, Integer> entry : params.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            Arrays.stream(thirdPart).forEach(w -> {
                if (w.charAt(0) == key && w.length() == value + 1) {
                    System.out.println(w);
                }
            });
        }
    }
}
