import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* On the first line, you will be given a list of wagons (integers).
        Each integer represents the number of passengers that are currently in each wagon.
        On the next line, you will get the max capacity of each wagon (single integer).
        Until you receive "end" you will be given two types of input:
•	Add {passengers} - add a wagon to the end with the given number of passengers
•	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
        At the end print the final state of the train (all the wagons separated by a space)*/

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            if(command[0].equals("Add")) {
                wagons.add(Integer.parseInt(command[1]));
            } else {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int newCapacity = wagons.get(i) + passengers;
                    if( newCapacity <= maxCapacity){
                        wagons.set(i, newCapacity);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
