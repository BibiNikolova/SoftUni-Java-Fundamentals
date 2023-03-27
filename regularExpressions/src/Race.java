import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> winners = new LinkedHashMap<>();
        participants.forEach(name -> winners.put(name, 0));

        String input = scanner.nextLine();
        while (!"end of race".equals(input)) {
            Pattern pattern = Pattern.compile("([A-Za-z])+");
            Matcher matcher = pattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                sb.append(matcher.group());
            }
            if (winners.containsKey(sb.toString())) {
                int sum = 0;
                Pattern pattern1 = Pattern.compile("[0-9]");
                Matcher matcher1 = pattern1.matcher(input);
                while (matcher1.find()) {
                    sum += Integer.parseInt(matcher1.group());
                }
                winners.put(sb.toString(), winners.get(sb.toString()) + sum);
            }
            input = scanner.nextLine();
        }
        List<String> firstThree = winners.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}
