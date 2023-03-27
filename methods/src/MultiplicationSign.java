import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int[] arr = {n1, n2, n3};

        if (isPositive(arr)) {
            System.out.println("positive");
        } else if (isNegative(arr)) {
            System.out.println("negative");
        } else if (isZero(arr)) {
            System.out.println("zero");
        }
    }

    private static boolean isZero(int[] arr) {

        for (int i = 0; i < 3; i++) {

            if (arr[i] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNegative(int[] arr) {

        int countNegativeNums = 0;

        for (int i = 0; i < 3; i++) {

            if (arr[i] < 0) {
                countNegativeNums++;
            }
        }
        if (countNegativeNums % 2 == 1) {
            return true;
        }
        return false;
    }

    private static boolean isPositive(int[] arr) {
        int countPositiveNums = 0;

        for (int i = 0; i < 3; i++) {

            if (arr[i] > 0) {
                countPositiveNums++;
            }
        }
        if (countPositiveNums % 2 == 1) {
            return true;
        }
        return false;
    }
}
