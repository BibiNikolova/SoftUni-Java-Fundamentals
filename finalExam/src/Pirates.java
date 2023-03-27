import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pirates {
    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return this.population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return this.gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<City> cities = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {
            String name = input.split("\\|{2}")[0];
            int population = Integer.parseInt(input.split("\\|{2}")[1]);
            int gold = Integer.parseInt(input.split("\\|{2}")[2]);

            City currentCity = findCity(cities, name);
            if (currentCity == null) {
                City city = new City(name, population, gold);
                cities.add(city);
            } else {
                int newPop = population + currentCity.getPopulation();
                currentCity.setPopulation(newPop);
                int newGold = currentCity.getGold() + gold;
                currentCity.setGold(newGold);
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
                for (City c : cities) {
                    if (c.getName().equals(town)) {
                        c.setPopulation(c.getPopulation() - people);
                        c.setGold(c.getGold() - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                        if (c.getPopulation() == 0 || c.getGold() == 0) {
                            cities.remove(c);
                            System.out.println(town + " has been wiped off the map!");
                        }
                        break;
                    }
                }
            } else {
                int gold = Integer.parseInt(command[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    for (City c : cities) {
                        if (c.getName().equals(town)) {
                            c.setGold(c.getGold() + gold);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, c.getGold());
                        }
                    }
                }
            }
            line = scanner.nextLine();
        }
        if (cities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.forEach(c -> System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg",
                    c.getName(),
                    c.getPopulation(),
                    c.getGold())));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }


    private static City findCity(List<City> cities, String name) {
        for (City c : cities) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}

