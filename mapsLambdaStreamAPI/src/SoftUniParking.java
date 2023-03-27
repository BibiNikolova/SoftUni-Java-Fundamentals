import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registrated = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.split(" ")[0].equals("register")) {
                String name = input.split(" ")[1];
                String license = input.split(" ")[2];
                if (!registrated.containsKey(name)) {
                    registrated.put(name, license);
                    System.out.printf("%s registered %s successfully%n", name, license);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", license);
                }

            } else {
                String name1 = input.split(" ")[1];
                if (!registrated.containsKey(name1)) {
                    System.out.printf("ERROR: user %s not found%n", name1);
                } else {
                    registrated.remove(name1);
                    System.out.printf("%s unregistered successfully%n", name1);
                }
            }
        }
        for (Map.Entry<String, String> entry : registrated.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
