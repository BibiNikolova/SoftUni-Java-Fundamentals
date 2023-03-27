import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Add {number}: add a number to the end of the list
        Remove {number}: remove a number from the list
        RemoveAt {index}: remove a number at a given index
        Insert {number} {index}: insert a number at a given index
        Note: All the indices will be valid!*/

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!"end". equals(input)){
            String[] command = input.split(" ");
            switch (command[0]){
                case "Add":
                    nums.add(Integer.parseInt(command[1]));
                    break;
                case"Remove":
                    Integer numToRemove = Integer.parseInt(command[1]);
                    nums.remove(numToRemove);
                    break;
                case"RemoveAt":
                    int index = Integer.parseInt(command[1]);
                    nums.remove(index);
                    break;
                case"Insert":
                    nums.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }

    }
}
