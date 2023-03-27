import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0;

        while (!"end of shift".equals(input)) {
            Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+)\\$");
            Matcher matcher = pattern.matcher(input);
            if (isValidOrder(input, pattern, matcher)) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double currentPrice = count * price;
                System.out.printf("%s: %s - %.2f%n", name, product, currentPrice);
                totalPrice += currentPrice;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPrice);
    }

    private static boolean isValidOrder(String input, Pattern pattern, Matcher matcher) {
        return matcher.find();
    }
}
