import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOpr {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List <Integer> numbersList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        int number = 0;

        int index = 0;

        while (!"End".equals(command)) {

            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {

                case "Add":
                    number = Integer.parseInt(commandArr[1]);
                    numbersList.add(number);
                    break;

                case "Insert":

                    number = Integer.parseInt(commandArr[1]);
                    index = Integer.parseInt(commandArr[2]);

                    if (isValidIndex(index, numbersList)) {
                        numbersList.add(index, number);

                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    index = Integer.parseInt(commandArr[1]);
                    if (isValidIndex(index, numbersList)) {
                        numbersList.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    String direction = commandArr[1];
                    int rotations = Integer.parseInt(commandArr[2]);
                    if (direction.equals("left")) {
                        rotateListLeft(numbersList, rotations);
                    } else {
                        Collections.rotate(numbersList, rotations);
                    }
                    break;
            }

            command = scan.nextLine();
        }

        for (int item : numbersList) {
            System.out.print(item + " ");
        }

    }

    public static boolean isValidIndex(int index, List<Integer> numbersList) {
        return (index >= 0 && index <= numbersList.size() - 1);
    }

    private static void rotateListLeft(List<Integer> numbersList, int rotations) {
        int savedNumber = 0;
        for (int index = 0; index < rotations; index++) {
            savedNumber = numbersList.get(0);
            numbersList.remove(0);
            numbersList.add(savedNumber);

        }
    }

//    private static void rotateListRight (List<Integer> numbersList, int rotations) {
//        int savedNumber = 0;
//        for (int index = 0; index < rotations; index++) {
////            Запазваме последния елемент
//            savedNumber = numbersList.get(numbersList.size() - 1);
////            Премахваме последния елемент
//            numbersList.remove(numbersList.size() - 1);
////            Слагаме последния елемент на първа позиция
//            numbersList.add(0, savedNumber);
//        }
//    }

}

