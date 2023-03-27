import java.util.Scanner;

public class TheatrePromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;
        char usd = '$';

        switch (typeOfDay) {
            case "Weekday":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    price = 12;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                } else {
                    break;
                }
                break;
            case "Weekend":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    price = 15;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                } else {
                    break;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                } else {
                    break;
                }
                break;
        }
        if (price > 0) {
            System.out.printf("%d%s",price, usd);
        } else {
            System.out.print("Error!");
        }
    }
}
