import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        switch (command){
            case "add":
                printAddedNums(a, b);
                break;
            case "multiply":
                printMultiplyedNums(a, b);
                break;
            case "subtract":
                printSubtractedNums(a, b);
                break;
            case "divide":
                printDividedNums(a, b);
                break;
        }
    }

    private static void printDividedNums(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }

    private static void printSubtractedNums(int a, int b) {
        int result = a - b;
        System.out.println(result);
    }

    private static void printMultiplyedNums(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

    private static void printAddedNums(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }
}
