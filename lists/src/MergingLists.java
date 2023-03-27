import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* You are going to receive two lists with numbers.
        Create a result list that contains the numbers from both of the lists.
        The first element should be from the first list, the second from the second list, and so on.
        If the length of the two lists is not equal, just add the remaining elements at the end of the list.*/

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int size = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < size; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }
        if (firstList.size() > secondList.size()) {
            result.addAll(firstList.subList(size, firstList.size()));
        } else {
            result.addAll(secondList.subList(size, secondList.size()));
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}




