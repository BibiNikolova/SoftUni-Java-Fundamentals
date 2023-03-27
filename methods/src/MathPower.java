import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        
        double result = mathPower(num, power);
        System.out.println(new DecimalFormat("0.####").format(result));

    }

    private static double mathPower(double num, int power) {

        double result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * num;
        }
        return result;
    }
}
