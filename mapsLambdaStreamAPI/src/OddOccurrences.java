import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        Map<String, Integer> oddTimes = new LinkedHashMap<>();

        for (String s : line) {
            String key = s.toLowerCase();
            if (!oddTimes.containsKey(key)) {
                oddTimes.put(key, 0);
            }
            oddTimes.put(key, oddTimes.get(key) + 1);
        }
        List<String> occurrence = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddTimes.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                occurrence.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", occurrence));
    }
}
