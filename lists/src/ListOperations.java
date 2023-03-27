import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Add":
                    nums.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int num = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);

                    if (index < nums.size() && index > - 1) {
                        nums.add(index, num);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removedIndex = Integer.parseInt(tokens[1]);

                    if (removedIndex < nums.size() && removedIndex > - 1) {
                        nums.remove(removedIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int times = Integer.parseInt(tokens[2]);

                    if ("right".equals(tokens[1])) {//last become first n times

                        for (int i = 0; i < times; i++) {
                            int lastNum = nums.size() - 1;
                            nums.add(0, nums.get(lastNum));
                            nums.remove(nums.size() - 1);
                        }
                    } else if ("left".equals(tokens[1])) {//first number becomes last

                        for (int i = 0; i < times; i++) {
                            int firstNum = nums.get(0);
                            nums.add(firstNum);
                            nums.remove(0);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
