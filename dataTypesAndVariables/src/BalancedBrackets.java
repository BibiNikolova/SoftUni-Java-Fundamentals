import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countOpen = 0;
        int countClose = 0;

        for (int lines = 0; lines < n; lines++) {
            String input = scanner.nextLine();
            for (int chars = 0; chars < input.length() ; chars++) {
                if (input.charAt(chars)== 40) {
                    countOpen ++;
                } else if (input.charAt(chars)== 41 && (countOpen - countClose == 1)) {
                    countClose ++;
                }
            }
        }
        if (countClose == countOpen) {
            System.out.print("BALANCED");
        } else {
            System.out.print("UNBALANCED");
        }
    }
}
