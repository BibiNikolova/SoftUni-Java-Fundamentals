import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double coins = 0;
        double price = 0;
        boolean isValid = true;

        while (!"Start".equals(input)) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0) {
                coins += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            switch (input) {
                case "Coke":
                    price = 1.0;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Nuts":
                    price = 2.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    isValid = false;
                    break;
            }
            if((coins - price >= 0) && ("Coke".equals(input) || "Soda".equals(input) || "Crisps".equals(input) || "Water".equals(input) || "Nuts".equals(input))) {
                System.out.printf("Purchased %s\n", input);
                coins -= price;
            } else if((coins - price >= 0) && !isValid) {

            } else if(coins - price < 0) {
                System.out.println("Sorry, not enough money");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", coins);

    }
}
