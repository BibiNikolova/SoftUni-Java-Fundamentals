import java.util.Scanner;

import static java.nio.file.Files.move;

public class TheImitationGameProblemDescription {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Decode".equals(input)) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Move":
                    int numOfLetters = Integer.parseInt(command[1]);
                    move(encryptedMessage, numOfLetters);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(command[1]);
                    String value = command[2];
                    insert(encryptedMessage, insertIndex, value);
                    break;
                case "ChangeAll":
                    String substring = command[1];
                    String replacement = command[2];
                    changeAll(encryptedMessage, substring, replacement);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command[0]);
            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }

    private static void changeAll(StringBuilder encryptedMessage, String substring, String replacement) {
        encryptedMessage.replace(0,encryptedMessage.length(), encryptedMessage.toString().replace(substring, replacement));
    }

    private static void insert(StringBuilder encryptedMessage, int insertIndex, String value) {
        encryptedMessage.insert(insertIndex, value);
    }

    private static void move(StringBuilder encryptedMessage, int numOfLetters) {
        String firstPart = encryptedMessage.substring(0, numOfLetters);
        encryptedMessage.append(firstPart);
        encryptedMessage.replace(0, numOfLetters, "");
    }
}
