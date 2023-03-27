package midExam;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int leftEnergy = energy;
        int countWins = 0;

        while (!"End of battle".equals(input)) {
            int distance = Integer.parseInt(input);

            if (leftEnergy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWins, leftEnergy);
                return;
            }
            leftEnergy -= distance;
            countWins += 1;
            if (countWins % 3 == 0) {
                leftEnergy += countWins;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", countWins, leftEnergy);
    }
}
