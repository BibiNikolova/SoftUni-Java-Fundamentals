import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        double factorialDivision = getFirstFactorial(n1) * 1.0/getSecondFactorial(n2);
        System.out.printf("%.2f", factorialDivision);
    }

    private static long getSecondFactorial(long n2) {
        long second = 1;
        for (int i = 1; i <= n2; i++) {
            second *= i;
        }
        return second;
    }

    private static long getFirstFactorial(long n1) {
        long first = 1;
        for (int i = 1; i <= n1; i++) {
            first *= i;
        }
        return first;
    }
}
