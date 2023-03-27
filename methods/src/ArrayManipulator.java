import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;
import static java.util.Arrays.stream;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    if (isValid(index, arr.length)) {
                        arr = getExchangedArray(arr, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "min":
                    if ("even".equals(command[1])) {
                        printMinEven(arr);
                    } else if ("odd".equals(command[1])) {
                        printMinOdd(arr);
                    }
                    break;
                case "max":
                    if ("even".equals(command[1])) {
                        printMaxEven(arr);
                    } else if ("odd".equals(command[1])) {
                        printMaxOdd(arr);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(command[1]);
                    if (!isValidCount(count, arr.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    if (command[2].equals("even")) {
                        printFirstNEven(arr, count);
                    } else if (command[2].equals("odd")) {
                        printFirstNOdd(arr, count);
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(command[1]);
                    if (!isValidCountLast(countLast, arr.length)) {
                        System.out.println("Invalid count");
                        input = scanner.nextLine();
                        continue;
                    }
                    if (command[2].equals("even")) {
                        printLastNEven(arr, countLast);
                    } else if (command[2].equals("odd")) {
                        printLastNOdd(arr, countLast);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void printLastNOdd(int[] arr, int countLast) {

        String elements = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                elements += arr[i] + " ";
                countLast--;
            }
            if (countLast == 0) {
                break;
            }
        }
        String[] finalOutput = elements.split(" ");
        System.out.print("[");
        for (int i = finalOutput.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(finalOutput[i]);
            } else {
                System.out.print(finalOutput[i] + ", ");
            }
        }
        System.out.println("]");
    }

    private static void printFirstNOdd(int[] arr, int count) {

        String output = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                output += arr[i] + " ";
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        String[] finalOutput = output.split(" ");
        System.out.print("[");
        for (int i = 0; i < finalOutput.length; i++) {
            if (i == finalOutput.length - 1) {
                System.out.print(finalOutput[i]);
            } else {
                System.out.print(finalOutput[i] + ", ");
            }
        }
        System.out.println("]");

    }

    private static void printMinOdd(int[] arr) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] <= min) {
                min = arr[i];
                minIndex = i;
            }
        }
        if (minIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minIndex);
        }
    }

    private static void printMaxOdd(int[] arr) {

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxIndex);
        }
    }

    private static boolean isValid(int index, int length) {
        return index >= 0 && index < length;
    }

    private static void printLastNEven(int[] arr, int countLast) {

        String elements = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                elements += arr[i]+ " ";
                countLast--;
            }
            if (countLast == 0) {
                break;
            }
        }
        String[] finalOutput = elements.split(" ");
        System.out.print("[");
        for (int i = finalOutput.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(finalOutput[i]);
            } else {
                System.out.print(finalOutput[i] + ", ");
            }
        }
        System.out.println("]");
    }

    private static boolean isValidCountLast(int countLast, int length) {
        return countLast <= length;
    }
    private static boolean isValidCount(int count, int length) {
        return count <= length;
    }

    private static void printFirstNEven(int[] arr, int count) {

        String output = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                output += arr[i] + " ";
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        String[] finalOutput = output.split(" ");
        System.out.print("[");
        for (int i = 0; i < finalOutput.length; i++) {
            if (i == finalOutput.length - 1) {
                System.out.print(finalOutput[i]);
            } else {
                System.out.print(finalOutput[i] + ", ");
            }
        }
        System.out.println("]");
    }

    private static void printMaxEven(int[] arr) {

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxIndex);
        }
    }

    private static void printMinEven(int[] arr) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= min) {
                min = arr[i];
                minIndex = i;
            }
        }
        if (minIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minIndex);
        }
    }

    private static int[] getExchangedArray(int[] arr, int index) {

        int[] tempTo = new int[arr.length - index - 1];
        for (int i = index + 1; i < arr.length; i++) {
            tempTo[i - index - 1] = arr[i];
        }
        int[] tempFrom0 = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            tempFrom0[i] = arr[i];
        }
        int[] exchanged = new int[arr.length];
        for (int i = 0; i < tempTo.length; i++) {
            exchanged[i] = tempTo[i];
        }
        for (int i = tempTo.length; i < exchanged.length; i++) {
            exchanged[i] = tempFrom0[i - tempTo.length];
        }
        return arr = exchanged;
    }

}


