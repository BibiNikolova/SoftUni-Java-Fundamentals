import java.util.Scanner;

public class RageExpences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lost = Integer.parseInt(scanner.nextLine());
        double headsetPrice  = Double.parseDouble(scanner.nextLine());
        double mousePrice  = Double.parseDouble(scanner.nextLine());
        double keyboardPrice  = Double.parseDouble(scanner.nextLine());
        double displayPrice  = Double.parseDouble(scanner.nextLine());
        int brokenHeadset  = lost / 2;
        int brokenKeyboard  = lost / 6;
        int brokenDisplay  = brokenKeyboard / 2;
        int brokenMouse  = lost / 3;
        double sum = brokenHeadset * headsetPrice
                + brokenMouse * mousePrice
                + brokenKeyboard * keyboardPrice
                + brokenDisplay * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
