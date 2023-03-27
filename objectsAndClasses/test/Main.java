package objectsAndClasses.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int readEngines = Integer.parseInt(scanner.nextLine());

        String[] engineData = scanner.nextLine().split("\\s+");

        for (int i = 0; i < readEngines; i++) {
            String engineModel = engineData[0];
            int enginePower = Integer.parseInt(engineData[1]);
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";


            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);

            engines.put(engineModel, engine);
        }

        List<Car> cars = new ArrayList<>();

        int carCount = Integer.parseInt(scanner.nextLine());
        
        String[] carData = scanner.nextLine().split("\\s+");

        for (int i = 0; i < carCount; i++) {
            String carModel = carData[0];
            String engineModel = carData[1];
            String carWeight = "n/a";
            String carColor = "n/a";

            switch (carData.length) {

                case 3:
                    if (!Character.isDigit(carData[2].charAt(0))) {
                        carColor = carData[2];
                    } else {
                        carWeight = carData[2];
                    }
                    break;
                case 4:
                    carWeight = carData[2];
                    carColor = carData[3];
                    break;
                default:
                    break;

            }

            Car car = new Car(carModel, engines.get(engineModel), carWeight, carColor);
            cars.add(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getModel() + ":");
            String check = cars.get(i).getEngine().getModel();
            System.out.println(engines.get(check).toString());
            System.out.println(cars.get(i).toString());
        }

    }
}