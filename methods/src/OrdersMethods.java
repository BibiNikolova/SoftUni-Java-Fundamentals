import java.util.Scanner;

public class OrdersMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        
        switch (product){
            case "coffee":
                printCoffeePrice(quantity);
                break;
            case "water":
                printWaterPrice(quantity);
                break;
            case "coke":
                printCokePrice(quantity);
                break;
            case "snacks":
                printSnacksPrice(quantity);
                break;
        }
    }

    private static void printSnacksPrice(int quantity) {
        double price = 2.00;
        System.out.printf("%.2f",price * quantity);
    }

    private static void printCokePrice(int quantity) {
        double price = 1.40;
        System.out.printf("%.2f",price * quantity);
    }

    private static void printWaterPrice(int quantity) {
        double price = 1.00;
        System.out.printf("%.2f",price * quantity);
    }

    private static void printCoffeePrice(int quantity) {
       double price = 1.50;
        System.out.printf("%.2f",price * quantity);
    }
}

