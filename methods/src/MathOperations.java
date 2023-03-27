import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        char input = scanner.nextLine().charAt(0);
        int n2 = Integer.parseInt(scanner.nextLine());

        double result = mathOperation(n1, input, n2);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double mathOperation(int n1, char input, int n2) {

        double result = 0;

        switch (input){
            case'+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case'*':
                result = n1 * n2;
                break;
            case'/':
                result = n1 * 1.0/ n2;
                break;
        }

        return result;
    }
}
