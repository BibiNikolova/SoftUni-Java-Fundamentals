import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("[, ]+");// M3ph-0.5s-0.5t0.0**
        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            int health = getHealth(name);
            double damage = getDamage(name);
            for (char c : name.toCharArray()) {
                if (c == '*') {
                    damage *= 2;
                } else if (c == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", name, health, damage);
        }

    }

    private static int getHealth(String name) {
        int currentHealth = 0;
        Pattern pattern = Pattern.compile("[^\\d+\\+\\-*\\/\\.]");
        Matcher matcher1 = pattern.matcher(name);
        while (matcher1.find()) {
            char currentCharValue = matcher1.group().charAt(0);
            currentHealth += currentCharValue;
        }
        return currentHealth;
    }

    private static double getDamage(String name) {
        double currentDamage = 0;
        Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(name);
        while (matcher.find()) {
            double currentNum = Double.parseDouble(matcher.group());
            currentDamage += currentNum;
        }
        return currentDamage;
    }
}
