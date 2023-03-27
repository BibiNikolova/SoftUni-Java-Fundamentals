import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> plants = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);

            plants.put(plant, new ArrayList<>());
            List<Integer> rarities = new ArrayList<>();
            rarities.add(rarity);
            plants.put(plant, rarities);

        }
        String line = scanner.nextLine();
        while (!"Exhibition".equals(line)) {
            String[] commands = line.split("(: )|( \\- )");
            String plant = commands[1];
            if (!plants.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (commands[0]) {
                    case "Rate":
                        int rating = Integer.parseInt(commands[2]);
                        plants.get(plant).add(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(commands[2]);
                        plants.get(plant).set(0, newRarity);
                        break;
                    case "Reset":
                        List<Integer> currentRate = plants.get(plant).subList(0, 1);
                        plants.put(plant, currentRate);
                        break;
                }
            }

            line = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Integer>> entry : plants.entrySet()) {
            double avg = 0.0;
            if (entry.getValue().size() > 1) {
                List<Integer> currentRating = entry.getValue().subList(1, entry.getValue().size());
                avg = currentRating
                        .stream().mapToInt(Integer::intValue)
                        .average()
                        .getAsDouble();
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), avg);
        }
    }
}
