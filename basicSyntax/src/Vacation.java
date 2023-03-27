import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;

        switch (day) {
            case "Friday":
                if ("Students".equals(type)) {
                    price = 8.45;
                } else if ("Business".equals(type)) {
                    price = 10.90;
                } else if ("Regular".equals(type)) {
                    price = 15;
                }
                break;
            case "Saturday":
                if ("Students".equals(type)) {
                    price = 9.80;
                } else if ("Business".equals(type)) {
                    price = 15.60;
                } else if ("Regular".equals(type)) {
                    price = 20;
                }
                break;
            case "Sunday":
                if ("Students".equals(type)) {
                    price = 10.46;
                } else if ("Business".equals(type)) {
                    price = 16.0;
                } else if ("Regular".equals(type)) {
                    price = 22.50;
                }
                break;
        }
        totalPrice = n * price;
        if ((n >= 30) && (type.equals("Students"))) {
            totalPrice *= 0.85;
        } else if ((n >= 100) && (type.equals("Business"))) {
            totalPrice = (n - 10) * price;
        } else if ((n >= 10 && n <= 20) && (type.equals("Regular"))) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
