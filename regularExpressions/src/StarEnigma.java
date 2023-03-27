import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@(?<name>[A-za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->(?<sCount>\\d+)");

        List<String> attack = new ArrayList<>();
        List<String> defense = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String encrypted = scanner.nextLine();
            String decrypted = getDecrypted(encrypted);
            Matcher matcher = pattern.matcher(decrypted);
            if (matcher.find()) {
                String planet = matcher.group("name");
                String attackOrDefence = matcher.group("attack");

                if(attackOrDefence.equals("A")){
                    attack.add(planet);
                } else if(attackOrDefence.equals("D")){
                    defense.add(planet);
                }
            }
        }
        System.out.println("Attacked planets: " + attack.size());
        Collections.sort(attack);
        attack.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + defense.size());
        Collections.sort(defense);
        defense.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecrypted(String encrypted) {
        int countLetters = getSpecialLettersCount(encrypted);
        StringBuilder decryptedMessage = new StringBuilder();
        for (char symbol : encrypted.toCharArray()) {
            char newC = (char) (symbol - countLetters);
            decryptedMessage.append(newC);
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLettersCount(String encrypted) {
        int count = 0;
        for (char symbol : encrypted.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }
        return count;
    }
}
