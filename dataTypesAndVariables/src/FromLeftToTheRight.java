import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;


        for (int i = 0; i < n; i++) {
            long firstNum = scanner.nextLong();
            long secondNum = scanner.nextLong();
            if (firstNum >= secondNum) {
                while (Math.abs(firstNum) > 0) {
                    sum += firstNum % 10;
                    firstNum /= 10;
                }
            } else {
                while (Math.abs(secondNum) > 0) {
                    sum += secondNum % 10;
                    secondNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
            sum = 0;
        }
    }
}

