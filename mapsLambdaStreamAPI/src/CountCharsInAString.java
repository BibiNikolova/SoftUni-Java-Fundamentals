import java.util.*;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> line = new LinkedHashMap<>();

        for (char key : input.toCharArray()) {
            if (key == ' ') {
                continue;
            }
            if (!line.containsKey(key)) {
                line.put(key, 0);
            }
            line.put(key, line.get(key) + 1);
        }
        for (Map.Entry<Character, Integer> entry : line.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
