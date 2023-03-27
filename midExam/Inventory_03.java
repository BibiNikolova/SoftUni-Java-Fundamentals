package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Craft!".equals(input)) {
            String[] command = input.split(" - ");
            String item = command[1];
            if ("Collect".equals(command[0])) {
                if (!isThere(items, item)) {
                    items.add(item);
                }
            } else if ("Drop".equals(command[0])) {
                if (isThere(items, item)) {
                    items.remove(item);
                }

            } else if ("Combine Items".equals(command[0])) {
                String[] combine = item.split(":");
                item = combine[0];
                int currentIndex = isThereIndex(items, item);
                if (currentIndex > -1) {
                    items.add(currentIndex + 1, combine[1]);
                }

            } else if ("Renew".equals(command[0])) {
                int currentIndex = isThereIndex(items, item);
                if (currentIndex > -1) {
                    items.add(item);
                    items.remove(currentIndex);
                }
            }
            input = scanner.nextLine();
        }
        printWithComma(items);
    }

    private static int isThereIndex(List<String> items, String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return items.indexOf(item);
            }
        }
        return -1;
    }

    private static boolean isThere(List<String> items, String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }
    private static void printWithComma(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            if (i < items.size() - 1) {
                System.out.print(items.get(i) + ", ");
            } else {
                System.out.println(items.get(i));
            }
        }
    }
}
