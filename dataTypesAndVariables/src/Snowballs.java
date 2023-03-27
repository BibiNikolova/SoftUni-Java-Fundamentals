import java.util.Scanner;
import java.util.function.DoublePredicate;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowBalls = Integer.parseInt(scanner.nextLine());
        double max = Double.MIN_VALUE;
        int maxSnow = Integer.MIN_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int maxQuality = Integer.MIN_VALUE;

        for (int i = 0; i < snowBalls; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);

            if (snowballValue > max) {
                max = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, max, maxQuality  );
    }
}
