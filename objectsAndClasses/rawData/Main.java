package rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<RawData.Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String model = input.split(" ")[0];
            int enginePower = Integer.parseInt(input.split(" ")[2]);
            String cargoType = input.split(" ")[4];

            double tyrePressure = 0;

            if (Double.parseDouble(input.split(" ")[5]) < 1 ||
                    Double.parseDouble(input.split(" ")[7]) < 1 ||
                    Double.parseDouble(input.split(" ")[9]) < 1 ||
                    Double.parseDouble(input.split(" ")[11]) < 1) {
                tyrePressure = 0.5;
            } else {
                tyrePressure = 1;
            }

            RawData.Car car = new RawData.Car(model, enginePower, cargoType,
                    tyrePressure);
            carList.add(car);
        }
        String command = scanner.nextLine();
        if ("fragile".equals(command)) {
            List<RawData.Car> fragile = carList.stream()
                    .filter(car -> car.getCargoType().equals("fragile"))
                    .collect(Collectors.toList());
            fragile.stream()
                    .filter(car -> (car.getTyrePressure() < 1))
                    .forEach(car -> System.out.println(car.toString()));
        } else if ("flamable".equals(command)) {
            List<RawData.Car> flamable = carList.stream()
                    .filter(car -> car.getCargoType().equals("flamable"))
                    .collect(Collectors.toList());
            flamable.stream()
                    .filter(car -> car.getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.toString()));
        }
    }
}
