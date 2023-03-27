import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymList.containsKey(key)) {
                synonymList.put(key, new ArrayList<>());
            }
            synonymList.get(key).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : synonymList.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
