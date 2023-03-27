import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      /*  Write a program to append several arrays of numbers.
	Arrays are separated by "|".
	Values are separated by spaces (" ", one or several).
	Order the arrays from the last to the first, and their values from left to right.
            1 2 3 |4 5 6 |  7  8
*/

        List<String> arrays = Arrays.stream(scanner.nextLine().split("[|]"))
                .collect(Collectors.toList());

        Collections.reverse(arrays);

        System.out.println(arrays.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));

    }
}
