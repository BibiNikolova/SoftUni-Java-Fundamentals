package midExam;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while ((!"End".equals(input))) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[1]);
            int value = Integer.parseInt(command[2]);
            switch ((command[0])) {
                case "Shoot":
                    if (isValidIndex(sequence, index)) {
                        if (sequence.get(index) - value > 0) {
                            sequence.set(index, sequence.get(index) - value);
                        } else {
                            sequence.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(sequence, index)) {
                        sequence.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index - value >= 0 && index + value <= sequence.size() - 1) {
                        for (int i = index - value; i <= index + value; i++) {
                            sequence.remove(index - value);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < sequence.size(); i++) {
            if (i < sequence.size() - 1) {
                System.out.print(sequence.get(i) + "|");
            } else {
                System.out.println(sequence.get(i));
            }
        }
    }

    private static boolean isValidIndex(List<Integer> sequence, int index) {
        return index >= 0 && index <= sequence.size() - 1;
    }
}
