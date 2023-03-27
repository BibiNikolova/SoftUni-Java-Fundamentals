import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();

        while (!"end".equals(input)) {
            for (char c : input.toCharArray()) {
                char current = (char)(c - n);
                encrypted.append(current);
            }
            input = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("(?<name>@[A-Za-z]+)[^@\\-!:>]+(?<behavior>![G|N]!)");
        Matcher matcher = pattern.matcher(encrypted);

        while (matcher.find()){
            String name = matcher.group("name");
            String behaviour = matcher.group("behavior");
            if(behaviour.contains("G")){
                System.out.println(name.substring(1));
            }
        }
    }
}
