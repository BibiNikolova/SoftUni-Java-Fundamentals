import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> target = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            int index = Integer.parseInt(commandLine[1]);
            int value = Integer.parseInt(commandLine[2]);
            switch (command) {
                case "Shoot":
                    if (isValidIndex(target, index)) {
                        int currentNum = target.get(index);
                        currentNum = currentNum - value;
                        if (currentNum <= 0) {
                            target.remove(index);
                        } else {
                            target.set(index, currentNum);
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(target, index)) {
                        target.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (isValidIndexRadius(target, index, value)) {
                        int radius = value * 2 + 1;
                        for (int i = 0; i < radius; i++) {
                            target.remove(index - value);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();

        }
        List<String> resultList = new ArrayList<>();
        for (int s : target) {
            resultList.add(String.valueOf(s));
        }
        System.out.println(String.join("|", resultList));
    }

    private static boolean isValidIndexRadius(List<Integer> target, int index, int value) {
        return target.size() - 1 >= index
                && target.size() - 1 >= index + value
                && index - value >= 0;
    }

    private static boolean isValidIndex(List<Integer> target, int index) {
        return index >= 0 && target.size() - 1 >= index;
    }
}
