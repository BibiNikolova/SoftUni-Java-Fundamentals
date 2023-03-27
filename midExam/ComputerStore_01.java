package midExam;

import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        while (!("special".equals(input) || "regular".equals(input))) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                sum += price;
            }
            input = scanner.nextLine();
        }
        if (sum == 0) {
            System.out.println("Invalid order!");
        } else {
            double sumWithTaxes = sum * 1.2;
            double taxes = sum * 0.2;
            double finalSum = 0;
            if ("special".equals(input)) {
                finalSum = sumWithTaxes * 0.9;
            } else if ("regular".equals(input)) {
                finalSum = sumWithTaxes;
            }

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", sum);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", finalSum);
        }
    }
}
