import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<name>[A-Za-z\\s]+)\\1(?<expire>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;
        List<String> items = new LinkedList<>();
        while (matcher.find()) {
            String name = matcher.group("name");
            String expire = matcher.group("expire");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", name, expire, calories));
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        for (String item : items) {
            System.out.println(item);
        }
    }
}
