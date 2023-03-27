package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirates = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int health = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Retire".equals(input)) {
            String[] command = input.split(" ");
            switch ((command[0])) {
                case "Fire":
                    int index = Integer.parseInt(command[1]);
                    if (isValidIndex(warship, index)) {
                        int damage = Integer.parseInt(command[2]);
                        warship.set(index, warship.get(index) - damage);
                        if (warship.get(index) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    int damageP = Integer.parseInt(command[3]);
                    if (isValidIndexP(pirates, startIndex, endIndex)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirates.set(i, pirates.get(i) - damageP);
                            if (pirates.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int index1 = Integer.parseInt(command[1]);
                    int repairHealth = Integer.parseInt(command[2]);
                    if (isValidIndexPirates(pirates, index1)) {
                        if (pirates.get(index1) + repairHealth > health) {
                            repairHealth = health;
                        } else {
                            repairHealth += pirates.get(index1);
                        }
                        pirates.set(index1, repairHealth);
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirates.size(); i++) {
                        if (pirates.get(i) < health * 0.2) {
                            count += 1;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", count);
                    break;
            }
            input = scanner.nextLine();
        }
        int sumP = 0;
        for (int i = 0; i < pirates.size(); i++) {
           sumP += pirates.get(i);
        }
        System.out.printf("Pirate ship status: %d\n", sumP);
        int sumW = 0;
        for (int i = 0; i < warship.size(); i++) {
            sumW += warship.get(i);
        }
        System.out.printf("Warship status: %d\n", sumW);
    }

    private static boolean isValidIndexPirates(List<Integer> pirates, int index) {
        return index >= 0 && index <= pirates.size() - 1;
    }

    private static boolean isValidIndexP(List<Integer> pirates, int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex <= pirates.size() - 1 && endIndex >= 0 && endIndex <= pirates.size() - 1;
    }

    private static boolean isValidIndex(List<Integer> warship, int index1) {
        return index1 >= 0 && index1 <= warship.size() - 1;
    }
}
