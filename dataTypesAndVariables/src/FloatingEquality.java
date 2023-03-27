import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double difference = Math.abs(a - b);

        if (difference > 0.000001) {
            System.out.print("False");
        } else if (difference == 0.000001){
            System.out.print("False");
        } else  {
            System.out.println("True");
        }
    }
}
