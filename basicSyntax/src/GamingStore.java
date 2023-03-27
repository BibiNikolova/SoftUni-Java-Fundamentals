import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double bought = 0;
        double price = 0;
        int notFound = 0;

        while (!"Game Time".equals(game)) {
            if ("OutFall 4".equals(game) || "RoverWatch Origins Edition".equals(game)) {
                price = 39.99;
            } else if ("CS: OG".equals(game)) {
                price = 15.99;
            } else if ("Zplinter Zell".equals(game)) {
                price = 19.99;
            } else if ("Honored 2".equals(game)) {
                price = 59.99;
            } else if ("RoverWatch".equals(game)) {
                price = 29.99;
            } else {
                System.out.println("Not Found");
                notFound = 1;
            }
            bought += price;
            if (bought <= sum && notFound != 1) {
                System.out.printf("Bought %s%n", game);
                if (bought == sum) {
                    System.out.println("Out of money!");
                    break;
                }
            } else if (bought > sum) {
                System.out.println("Too Expensive");
                bought -= price;
            }
            notFound = 0;
            game = scanner.nextLine();
        }
        if (sum > bought) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", bought, sum - bought);
        }
    }
}
