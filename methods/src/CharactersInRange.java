import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        printAllChars(first, second);// всички символи м/у двата от ASCII в поредица
    }

    private static void printAllChars(char first, char second) {

        int length = Math.abs(first - second) - 1;
        char[] arr = new char[length];

        if (first > second) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ++second;
            }

        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ++first;
            }
        }

        for (char c : arr) {
            System.out.print(c + " ");
        }
    }
}

