import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            if(isPalindrome(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        String[] arr = input.split("");
        boolean isArrParindrome = true;
        for (int i = 0; i < arr.length/ 2; i++) {
            if(arr[i].equals(arr[arr.length - 1 - i])) {
                isArrParindrome = true;
            } else {
                isArrParindrome = false;
            }
        }
        if (isArrParindrome) {
            return true;
        }
        return false;
    }
}
