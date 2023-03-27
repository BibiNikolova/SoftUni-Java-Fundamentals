import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*You will be given a list of numbers and a string.
        For each element of the list, you have to take the sum of its digits and take the element corresponding to that index from the text.
        If the index is greater than the length of the text, start counting from the beginning (so that you always have a valid index).
        After getting the element from the text, you have to remove the character you have taken from it
        (so for the next index, the text will be with one characterless).*/
        List<String> numbers = stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        for (int i = 0; i < numbers.size(); i++) {
            int[] currentN = stream(numbers.get(i).split(""))
                    .mapToInt(Integer::parseInt).toArray();
            int elementIndex = 0;
            for (int j = 0; j < currentN.length; j++) {
                elementIndex += currentN[j];
            }
            List<String> text = stream(input.split(""))
                            .collect(Collectors.toList());
            if(elementIndex > text.size() - 1) {
                int textElementIndex = elementIndex/text.size();
                System.out.print(text.get(textElementIndex));
                text.remove(textElementIndex);
            } else {
                System.out.print(text.get(elementIndex));
                text.remove(elementIndex);
            }
            input = String.join("",text);
        }
    }
}
