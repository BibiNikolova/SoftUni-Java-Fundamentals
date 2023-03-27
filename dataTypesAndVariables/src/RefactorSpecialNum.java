import java.util.Scanner;

public class RefactorSpecialNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = i;

            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }

            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
            sum = 0;
        }
    }
}


