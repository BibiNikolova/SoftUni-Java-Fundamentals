package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> grocery = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Go Shopping!".equals(input)) {
            String[] command = input.split(" ");
            String item = command[1];
            switch (command[0]) {
                case "Urgent":
                    if (!isThere(grocery, item)) {
                        grocery.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    int toRemove = isThereAnItem(grocery, item);
                    if(toRemove > -1) {
                        grocery.remove(toRemove);
                    }
                    break;
                case "Correct":
                    String newItem = command[2];
                    int toCorrect = isThereAnItem(grocery, item);
                    if(toCorrect > - 1) {
                        grocery.set(toCorrect, newItem);
                    }
                    break;
                case "Rearrange":
                    int toRearrange = isThereAnItem(grocery, item);
                    if(toRearrange > - 1) {
                        grocery.add(item);
                        grocery.remove(toRearrange);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < grocery.size(); i++) {
            if (i < grocery.size() - 1) {
                System.out.print(grocery.get(i) + ", ");
            } else {

                System.out.println(grocery.get(i));
            }
        }
    }

    private static boolean isThere(List<String> grocery, String item) {
        for (int i = 0; i < grocery.size(); i++) {
            if (grocery.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    private static int isThereAnItem(List<String> grocery, String item) {
        for (int i = 0; i < grocery.size(); i++) {
            if (grocery.get(i).equals(item)) {
                return grocery.indexOf(item);
            }
        }
        return - 1;
    }
}
