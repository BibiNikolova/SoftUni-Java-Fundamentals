import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();

        String pas = "";
        int count = 0;

        for (int i = user.length() - 1; i >= 0; i--) {
            char pass = user.charAt(i);
            pas += pass;
        }
        String password = scanner.nextLine();

        while (!pas.equals(password)){
            count++;
            if (count != 4) {
                System.out.print("Incorrect password. Try again.\n");
            } else {
                break;
            }
            password = scanner.nextLine();
        }
        if (count == 4) {
            System.out.printf("User %s blocked!", user);
        } else {
            System.out.printf("User %s logged in.", user);
        }
    }
}


