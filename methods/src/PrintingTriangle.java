import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for (int length = 1; length <= num; length++) {
          printIncreasingNum(length);
        }
        for (int length = num - 1; length > 0; length--) {
            printIncreasingNum(length);
        }
    }

    private static void printIncreasingNum(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print(i);
            if (i < length) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
