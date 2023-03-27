import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            Matcher matcher = Pattern.compile("([|])(?<boss>[A-Z]{4,})\\1:([#])(?<title>[A-Za-z]+\\ [A-Za-z]+)\\3").matcher(input);
            if (matcher.find()) {
                String boss = matcher.group("boss");
                String title = matcher.group("title");
                System.out.println(boss + ", The " + title );
                System.out.printf(">> Strength: %d\n>> Armor: %d%n", boss.length(), title.length());
            } else {
                System.out.println("Access denied!");

            }
        }
    }
}
