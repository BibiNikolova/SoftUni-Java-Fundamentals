import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int poured = 0;

        for (int i = 0; i < lines; i++) {
            int quantities = Integer.parseInt(scanner.nextLine());
            if (poured + quantities <= 255) {
                poured += quantities;
            } else {
                System.out.println("Insufficient capacity!");
            }

        }
        System.out.println(poured);
    }
}
