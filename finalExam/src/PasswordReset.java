import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Done".equals(input)) {
            String command = input.split(" ")[0];
            switch (command) {
                case "TakeOdd":
                    printNewPass(password);
                    break;
                case "Cut":
                    printCutted(password, input);
                    break;
                case "Substitute":
                    printSubstitute(password, input);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }

    private static void printSubstitute(StringBuilder password, String input) {
        String substring = input.split(" ")[1];
        String substitute = input.split(" ")[2];
        if (password.toString().contains(substring)) {
            String newPass = password.toString().replace(substring, substitute);
            password.setLength(0);
            password.append(newPass);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
    }


    private static void printCutted(StringBuilder password, String input) {
        int index = Integer.parseInt(input.split(" ")[1]);
        int length = Integer.parseInt(input.split(" ")[2]);
        password.replace(index, index + length, "");
        System.out.println(password);
    }

    private static void printNewPass(StringBuilder password) {
        StringBuilder newPass = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPass.append(password.charAt(i));
            }
        }
        password.setLength(0);
        password.append(newPass);
        System.out.println(password);
    }
}
