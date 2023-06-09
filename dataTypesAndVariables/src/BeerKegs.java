import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxVolume = Double.MIN_VALUE;
        String maxModel = "";

        for (int keg = 1; keg <= n; keg++) {
            String model = scanner.nextLine();;
            double r = Double.parseDouble(scanner.nextLine());
            int h = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * Math.pow(r, 2) * h;

            if (volume > maxVolume) {
                maxVolume = volume;
                maxModel = model;
            }
        }
        System.out.println(maxModel);

    }
}
