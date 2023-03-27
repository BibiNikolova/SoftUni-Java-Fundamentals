import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char x = 'X';

        for (int j = 1; j <= 10; j++) {
            int multip = n * j;
            System.out.printf("%d %s %d = %d\n", n, x, j, multip);

        }
    }
}

