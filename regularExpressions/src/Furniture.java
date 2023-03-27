import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double sum = 0;
        while (!"Purchase".equals(input)) {
            Pattern pattern = Pattern.compile("(\\>{2})(?<name>[A-Z]+[a-z]*)(\\<{2})(?<price>\\d+|\\d+.\\d+)!(?<qant>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furniture.add(matcher.group("name"));
                int quant = Integer.parseInt(matcher.group("qant"));
                double price = Double.parseDouble(matcher.group("price"));
                sum += quant * price;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }

}
