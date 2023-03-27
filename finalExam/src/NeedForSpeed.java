import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> autopark = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] spec = scanner.nextLine().split("\\|");
            List<Integer> data = new ArrayList<>();
            data.add(Integer.parseInt(spec[1]));
            data.add(Integer.parseInt(spec[2]));

            autopark.put(spec[0], data);
        }
        String input = scanner.nextLine();

        while (!"Stop".equals(input)) {
            String command = input.split(" : ")[0];
            String car = input.split(" : ")[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(input.split(" : ")[2]);
                    int fuel = Integer.parseInt(input.split(" : ")[3]);
                    printDrive(autopark, car, distance, fuel);
                    if (autopark.get(car).get(0) >= 100000) {
                        autopark.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(input.split(" : ")[2]);
                    printRefuel(autopark, car, refuel);
                    break;
                case "Revert":
                    int km = Integer.parseInt(input.split(" : ")[2]);
                    decreasedMilage(autopark, car, km);
                    if (autopark.get(car).get(0) >= 10000) {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        autopark.entrySet().forEach(e -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1));
        });
    }

    private static void decreasedMilage(Map<String, List<Integer>> autopark, String car, int km) {
        int decreased = autopark.get(car).get(0) - km;
        if (decreased <= 10000) {
            decreased = 10000;
        }
        List<Integer> currentValue = autopark.get(car);
        currentValue.set(0, decreased);
        autopark.put(car, currentValue);
    }

    private static void printRefuel(Map<String, List<Integer>> autopark, String car, int refuel) {
        int currentFuel = autopark.get(car).get(1);
        int refueled = autopark.get(car).get(1) + refuel;
        if (refueled >= 75) {
            refueled = 75;
        }
        List<Integer> currentValue = autopark.get(car);
        currentValue.set(1, refueled);
        autopark.put(car, currentValue);
        System.out.printf("%s refueled with %d liters%n", car, refueled - currentFuel);
    }

    private static void printDrive(Map<String, List<Integer>> autopark, String car, int distance, int fuel) {
        int currentFuel = autopark.get(car).get(1);
        if (fuel > currentFuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            int increasedDistance = autopark.get(car).get(0) + distance;
            int decreasedFuel = autopark.get(car).get(1) - fuel;
            List<Integer> currentValue = new ArrayList<>();
            currentValue.add(increasedDistance);
            currentValue.add(decreasedFuel);

            autopark.put(car, currentValue);
            System.out.println(car + " driven for " + distance + " kilometers. " + fuel + " liters of fuel consumed.");
        }
    }
}
