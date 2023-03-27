import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        for (int topInt = 1; topInt <= length; topInt++) {
            if (isSumOfDigitsDivisibleBy8(topInt) && holdsOneOddDigit(topInt)) {
                System.out.println(topInt);
            }
        }
    }

    private static boolean holdsOneOddDigit(int topInt) {
        while (topInt > 0) {
            int lastNum = topInt % 10;
            if (lastNum % 2 != 0) {
                return true;
            }
            topInt /= 10;
        }
        return false;
    }

    private static boolean isSumOfDigitsDivisibleBy8(int topInt) {
        int sum = 0;
        while (topInt > 0) {
            int lastNum = topInt % 10;
            sum += lastNum;
            topInt /= 10;
        }
        return sum % 8 == 0;
    }
}
