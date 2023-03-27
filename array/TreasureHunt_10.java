package array;

import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String[] inputArr = text.split("\\|");

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandArr = command.split("\\s+");

            if (command.contains("Loot")) {
                for (int i = 1; i < commandArr.length; i++) {
                    String checkWord = commandArr[i];
                    boolean alreadyContains = false;
                    for (int j = 0; j < inputArr.length; j++) {
                        String inputWord = inputArr[j];
                        if (checkWord.equals(inputWord)) {
                            alreadyContains = true;
                            break;
                        }
                    }
                    if (!alreadyContains) {
                        String check = checkWord + " " + String.join(" ", inputArr);
                        inputArr = check.split("\\s+");
                    }
                }

            } else if (command.contains("Drop")) {
                String[] dropArr = command.split("\\s+");
                int index = Integer.parseInt(dropArr[1]);
                if (index >= 0 && index <= inputArr.length - 1) {
                    String word = inputArr[index];
                    for (int i = index; i < inputArr.length - 1; i++) {
                        inputArr[i] = inputArr[i + 1];
                    }
                    inputArr[inputArr.length - 1] = word;
                }

            } else if (command.contains("Steal")) {
                int index = Integer.parseInt(commandArr[1]);

                if (index >= 0 && index < inputArr.length) {
                    for (int i = 0; i < index; i++) {
                        System.out.print(inputArr[inputArr.length - index + i]);
                        if (i != index - 1) {
                            System.out.print(", ");
                        }
                    }
                    String[] resultArr = new String[inputArr.length - index];
                    for (int i = 0; i < resultArr.length; i++) {
                        resultArr[i] = inputArr[i];
                    }
                    inputArr = resultArr;

                } else if (index >= inputArr.length) {
                    for (int i = 0; i < inputArr.length; i++) {
                        System.out.print(inputArr[i]);
                        if (i != inputArr.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    inputArr = new String[0];
                }
                System.out.println();
                break;
            }

            command = scanner.nextLine();
        }
        String treasureCount = String.join("", inputArr);
        int counter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            counter++;
        }
        double result = counter * 1.0 / inputArr.length;
        if (counter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", result);
        } else {
            System.out.println("Failed treasure hunt.");
        }

    }
}

