import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"
        Print even – print all the numbers that are even separated by a space
        Print odd – print all the numbers that are oddly separated by a space
        Get sum – print the sum of all the numbers
        Filter {condition} {number} – print all the numbers that fulfill that condition.
        The condition will be either '<', '>', ">=", "<="
*/
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Contains":
                    if (isNumInList(nums, command)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        printEven(nums, command);
                    } else {
                        printOdd(nums, command);
                    }
                    break;
                case "Get":
                    if(command[1].equals("sum")) {
                        int sum = 0;
                        for (int i = 0; i < nums.size(); i++) {
                            sum += nums.get(i);
                        }
                        System.out.println(sum);
                    }
                    break;
                case "Filter":
                    int n = Integer.parseInt(command[2]);
                    if (command[1].equals("<")) {
                        for (int i = 0; i < nums.size(); i++) {
                            if (nums.get(i) < n) {
                                System.out.print(nums.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (command[1].equals(">")) {
                        for (int i = 0; i < nums.size(); i++) {
                            if (nums.get(i) > n) {
                                System.out.print(nums.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (command[1].equals(">=")) {
                        for (int i = 0; i < nums.size(); i++) {
                            if (nums.get(i) >= n) {
                                System.out.print(nums.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (command[1].equals("<=")) {
                        for (int i = 0; i < nums.size(); i++) {
                            if (nums.get(i) <= n) {
                                System.out.print(nums.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
            input = scanner.nextLine();
        }

    }

    private static void printOdd(List<Integer> nums, String[] command) {
        List<Integer> oddNums = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 != 0) {
                oddNums.add(nums.get(i));
            }
        }
        for (Integer evenNum : oddNums) {
            System.out.print(evenNum + " ");
        }
        System.out.println();
    }

    private static void printEven(List<Integer> nums, String[] command) {
        List<Integer> evenNums = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                evenNums.add(nums.get(i));
            }
        }
        for (Integer evenNum : evenNums) {
            System.out.print(evenNum + " ");
        }
        System.out.println();
    }


    private static boolean isNumInList(List<Integer> nums, String[] command) {
        int index = Integer.parseInt(command[1]);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == index) {
                return true;
            }
        }
        return false;
    }
}
