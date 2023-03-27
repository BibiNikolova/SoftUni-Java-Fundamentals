import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multipl = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        char x = 'X';

        if (multipl > 10) {
            sum = n * multipl;
            System.out.printf("%d %s %d = %d\n", n, x, multipl, sum);
        } else {
            for (int i = multipl; i <= 10; i++) {
                sum = n * i;
                System.out.printf("%d %s %d = %d\n", n, x, i, sum);
            }
        }
    }
}
