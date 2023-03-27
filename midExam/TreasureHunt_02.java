package midExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasure = Arrays.stream(scanner.nextLine().split("[|]"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Yohoho!".equals(input)) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Loot":
                    for (int i = 1; i < commands.length; i++) {
                        String addLoot = commands[i];
                        boolean isInTreasure = false;
                        for (int j = 0; j < treasure.size(); j++) {
                            String loot = treasure.get(j);
                            if (loot.equals(addLoot)) {
                                isInTreasure = true;
                                break;
                            }
                        }
                        if (!isInTreasure) {
                            treasure.add(0, addLoot);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commands[1]);
                    if (index >= treasure.size() || index < 0) {
                        break;
                    } else {
                        treasure.add(treasure.get(index));
                        treasure.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commands[1]);
                    List<String> stolen = new ArrayList<>();
                    if (count > treasure.size()) {
                        stolen.addAll(treasure);
                        treasure.removeAll(treasure);
                    } else {
                        stolen.addAll(treasure.subList(treasure.size() - count, treasure.size()));
                        treasure.removeAll(treasure.subList(treasure.size() - count, treasure.size()));
                    }

                    for (int i = 0; i < stolen.size(); i++) {
                        if (i == stolen.size() - 1) {
                            System.out.print(stolen.get(i));
                        } else {
                            System.out.print(stolen.get(i) + ", ");
                        }
                    }
                    System.out.println();

                    break;
            }
            input = scanner.nextLine();
        }
        String joined = String.join("", treasure);
        double length = joined.length();
        double average = length/treasure.size();
        if (treasure.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }
    }
}





