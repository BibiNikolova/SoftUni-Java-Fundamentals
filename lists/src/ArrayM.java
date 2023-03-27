package lists.src;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                int firstElement = numbersList.get(index1);
                int secondElement = numbersList.get(index2);
                numbersList.set(index1, secondElement);
                numbersList.set(index2, firstElement);

            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                int firstElement = numbersList.get(index1);
                int secondElement = numbersList.get(index2);
                int newElement = firstElement * secondElement;
                numbersList.set(index1, newElement);

            } else if (command.contains("decrease")) {
                for (int index = 0; index <= numbersList.size() - 1; index++) {
                    int newNumber = numbersList.get(index);
                    numbersList.set(index, newNumber - 1);
                }
            }

            command = scanner.nextLine();
        }
        for (int number : numbersList) {
            if (number != numbersList.get(numbersList.size() - 1)) {
                System.out.print(number + ", ");
            } else {
                System.out.println(number);
            }
        }
    }
}
