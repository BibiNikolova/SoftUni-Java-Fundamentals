import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger factoriel = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factoriel = factoriel.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factoriel);
    }
}
