import java.util.Scanner;

public class SumOfOddNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int odd = 1;
        int sum = 0;

        for (int i = 0; i < n ; i ++) {
            System.out.println(odd);
            sum += odd;
            odd += 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}
