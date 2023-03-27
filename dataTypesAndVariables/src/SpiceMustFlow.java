import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalAmount = 0;
        while (yield >= 100) {
            int spices = yield - 26;
            totalAmount += spices;
            days++;
            yield -= 10;
        }
        System.out.println(days);
        if (totalAmount >= 26) {
            totalAmount -= 26;
        }
        System.out.println(totalAmount);
    }
}

