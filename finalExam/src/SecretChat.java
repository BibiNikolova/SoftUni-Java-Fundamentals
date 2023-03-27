import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();

        while (!"Reveal".equals(line)) {
            String[] command = line.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    message.insert(index," ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String sub = command[1];
                    if (message.toString().contains(sub)) {
                        StringBuilder reversed = new StringBuilder(sub);
                        reversed.reverse();
                        int startIndex = message.indexOf(sub);
                        message.replace(startIndex, startIndex + sub.length(), "");
                        message.append(reversed);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String current = message.toString();
                    String toBeChanged = command[1];
                    String change = command[2];
                    current = current.replace(toBeChanged, change);
                    System.out.println(current);
                    message = new StringBuilder(current);
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
