import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 0; i < n; i++) {
            double price = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int count = Integer.parseInt(scanner.nextLine());
            double order = price * days * count;
            System.out.printf("The price for the coffee is: $%.2f\n", order);
            totalPrice += order;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
