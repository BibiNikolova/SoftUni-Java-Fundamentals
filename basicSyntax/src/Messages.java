import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String word = "";

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            int mainDigit = num % 10;
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset += 1;
            } else if (mainDigit == 0) {
                offset = -65;
            }
            String digit = "" + num;
            int index = (offset + digit.length() - 1);
            word += (char) (index + 97);
        }
        System.out.println(word);
    }
}
