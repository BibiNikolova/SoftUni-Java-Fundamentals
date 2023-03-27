import java.util.Arrays;
import java.util.Scanner;

//80/100...да се прегледа steal
public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasure = scanner.nextLine().split("[|]");
        String input = scanner.nextLine();

        while (!"Yohoho!".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i < command.length; i++) {
                        boolean isequal = false;
                        for (int j = 0; j < treasure.length; j++) {
                            if (command[i].equals(treasure[j])) {
                                isequal = true;
                                break;
                            }
                        }
                        if (!isequal) {
                            String temp = command[i] + " " + String.join(" ", treasure);// Insert the items at the beginning of the chest
                            treasure = temp.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(command[1]);
                    if (dropIndex < treasure.length && dropIndex >= 0) {
                        String lastElement = treasure[dropIndex];
                        for (int i = dropIndex; i < treasure.length - 1; i++) {
                            treasure[i] = treasure[i + 1];
                        }
                        treasure[treasure.length - 1] = lastElement;
                    } else {
                        break;
                    }
                    break;
                case "Steal":
                    int lastElements = Integer.parseInt(command[1]);
                    for (int i = treasure.length - lastElements; i < treasure.length; i++) {
                        if (treasure.length - lastElements < 0) {
                            i = 0;
                        }
                        if (i != treasure.length - 1) {
                            System.out.print(treasure[i] + ", ");
                        } else {
                            System.out.println(treasure[i]);
                        }
                    }
                    String temp = "";
                    for (int i = 0; i < treasure.length - lastElements; i++) {
                        temp += treasure[i] + " ";
                    }
                    treasure = temp.split(" ");
                    break;
            }
            input = scanner.nextLine();
        }
        double sumLength = 0;
        for (String s : treasure) {
            sumLength += s.length();
        }
        double averageGain = sumLength / treasure.length;
        if (averageGain > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
