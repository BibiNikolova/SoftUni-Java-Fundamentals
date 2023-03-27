import java.util.*;

public class Pirates2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> cities = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {
            String name = input.split("\\|{2}")[0];
            int population = Integer.parseInt(input.split("\\|{2}")[1]);
            int gold = Integer.parseInt(input.split("\\|{2}")[2]);

            List<Integer> value = new ArrayList<>();
            value.add(population);
            value.add(gold);

            if (cities.containsKey(name)) {
                List<Integer> currentValue = new ArrayList<>();
                int newPop = population + cities.get(name).get(0);
                int newGold = cities.get(name).get(1) + gold;
                currentValue.add(newPop);
                currentValue.add(newGold);

                cities.put(name, currentValue);
            } else {
                cities.put(name, value);
            }
            input = scanner.nextLine();
        }
        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] command = line.split("=>");
            String town = command[1];
            if ("Plunder".equals(command[0])) {
                int people = Integer.parseInt(command[2]);
                int gold = Integer.parseInt(command[3]);
                int newPop = cities.get(town).get(0) - people;
                int newGold = cities.get(town).get(1) - gold;
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                cities.get(town).set(0, newPop);
                cities.get(town).set(1, newGold);
                if (newPop == 0 || newGold == 0) {
                    cities.remove(town);
                    System.out.println(town + " has been wiped off the map!");
                }
            } else {
                int gold = Integer.parseInt(command[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int newGold = cities.get(town).get(1) + gold;
                    cities.get(town).set(1, newGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, newGold);
                }
            }
            line = scanner.nextLine();
        }
        if (cities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet().forEach(c ->
                    System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg",
                            c.getKey(),
                            c.getValue().get(0),
                            c.getValue().get(1))));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}

