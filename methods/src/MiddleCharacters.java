import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printMiddleSymbols(text);

    }

    private static void printMiddleSymbols(String text) {
        if(text.length() % 2 != 0) {
            System.out.println(text.charAt(text.length()/2));
        } else {
            System.out.print(text.charAt(text.length()/2 - 1));
            System.out.print(text.charAt(text.length()/2));
        }

    }
}
